package br.com.cabrapi.sdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Json {

    private static final DateTimeFormatter ISO_FORMAT = DateTimeFormatter.ISO_DATE_TIME;

    public static String toJson(Object obj) {
        if (obj == null) return "null";
        StringBuilder sb = new StringBuilder();
        toJsonValue(obj, sb);
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static void toJsonValue(Object obj, StringBuilder sb) {
        if (obj == null) {
            sb.append("null");
        } else if (obj instanceof String) {
            sb.append('"').append(escape((String) obj)).append('"');
        } else if (obj instanceof Number || obj instanceof Boolean) {
            sb.append(obj);
        } else if (obj instanceof LocalDateTime) {
            sb.append('"').append(((LocalDateTime) obj).format(ISO_FORMAT)).append('"');
        } else if (obj instanceof Enum) {
            sb.append('"').append(obj.toString()).append('"');
        } else if (obj instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) obj;
            sb.append('{');
            boolean first = true;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!first) sb.append(',');
                first = false;
                sb.append('"').append(escape(entry.getKey())).append('"').append(':');
                toJsonValue(entry.getValue(), sb);
            }
            sb.append('}');
        } else if (obj instanceof Collection) {
            Collection<?> list = (Collection<?>) obj;
            sb.append('[');
            boolean first = true;
            for (Object item : list) {
                if (!first) sb.append(',');
                first = false;
                toJsonValue(item, sb);
            }
            sb.append(']');
        } else if (obj.getClass().isArray()) {
            Object[] arr = (Object[]) obj;
            sb.append('[');
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) sb.append(',');
                toJsonValue(arr[i], sb);
            }
            sb.append(']');
        } else {
            objectToJson(obj, sb);
        }
    }

    private static void objectToJson(Object obj, StringBuilder sb) {
        sb.append('{');
        boolean first = true;
        for (Field field : getAllFields(obj.getClass())) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value != null) {
                    if (!first) sb.append(',');
                    first = false;
                    String name = fieldName(field);
                    sb.append('"').append(escape(name)).append('"').append(':');
                    toJsonValue(value, sb);
                }
            } catch (IllegalAccessException ignored) {
            }
        }
        sb.append('}');
    }

    private static String fieldName(Field field) {
        JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        return field.getName();
    }

    private static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        Class<?> current = clazz;
        while (current != null && current != Object.class) {
            Collections.addAll(fields, current.getDeclaredFields());
            current = current.getSuperclass();
        }
        return fields;
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json == null || json.trim().isEmpty()) return null;
        Object parsed = parseValue(json.trim());
        return (T) convert(parsed, clazz);
    }

    private static Object parseValue(String json) {
        json = json.trim();
        if (json.startsWith("{")) return parseObject(json);
        if (json.startsWith("[")) return parseArray(json);
        if (json.startsWith("\"")) return json.substring(1, json.length() - 1).replace("\\\"", "\"").replace("\\\\", "\\").replace("\\n", "\n").replace("\\t", "\t");
        if ("true".equals(json) || "false".equals(json)) return Boolean.parseBoolean(json);
        if ("null".equals(json)) return null;
        if (json.contains(".")) return Double.parseDouble(json);
        return Long.parseLong(json);
    }

    private static Map<String, Object> parseObject(String json) {
        Map<String, Object> map = new LinkedHashMap<>();
        json = json.trim().substring(1, json.length() - 1).trim();
        if (json.isEmpty()) return map;

        int i = 0;
        while (i < json.length()) {
            while (i < json.length() && json.charAt(i) <= ' ') i++;
            if (i >= json.length()) break;

            if (json.charAt(i) != '"') throw new RuntimeException("Expected key at position " + i);
            i++;
            StringBuilder key = new StringBuilder();
            while (i < json.length() && json.charAt(i) != '"') {
                if (json.charAt(i) == '\\') { i++; if (i < json.length()) key.append(json.charAt(i)); }
                else key.append(json.charAt(i));
                i++;
            }
            i++;

            while (i < json.length() && json.charAt(i) <= ' ') i++;
            if (i >= json.length() || json.charAt(i) != ':') throw new RuntimeException("Expected ':'");
            i++;

            while (i < json.length() && json.charAt(i) <= ' ') i++;

            ParseResult parsedValue = parseAnyValue(json, i);
            map.put(key.toString(), parsedValue.value);
            i = parsedValue.endIndex;

            while (i < json.length() && json.charAt(i) <= ' ') i++;
            if (i < json.length() && json.charAt(i) == ',') i++;
        }
        return map;
    }

    private static List<Object> parseArray(String json) {
        List<Object> list = new ArrayList<>();
        json = json.trim().substring(1, json.length() - 1).trim();
        if (json.isEmpty()) return list;

        int i = 0;
        while (i < json.length()) {
            while (i < json.length() && json.charAt(i) <= ' ') i++;
            if (i >= json.length()) break;

            ParseResult result = parseAnyValue(json, i);
            list.add(result.value);
            i = result.endIndex;

            while (i < json.length() && json.charAt(i) <= ' ') i++;
            if (i < json.length() && json.charAt(i) == ',') i++;
        }
        return list;
    }

    private static ParseResult parseAnyValue(String json, int start) {
        json = json.trim();
        char c = json.charAt(start);
        if (c == '{') {
            int end = findMatchingClose(json, start, '{', '}');
            return new ParseResult(parseObject(json.substring(start, end + 1)), end + 1);
        }
        if (c == '[') {
            int end = findMatchingClose(json, start, '[', ']');
            return new ParseResult(parseArray(json.substring(start, end + 1)), end + 1);
        }
        if (c == '"') {
            int end = start + 1;
            while (end < json.length()) {
                if (json.charAt(end) == '\\') end += 2;
                else if (json.charAt(end) == '"') break;
                else end++;
            }
            String val = json.substring(start + 1, end);
            return new ParseResult(val.replace("\\\"", "\"").replace("\\\\", "\\"), end + 1);
        }
        int end = start;
        while (end < json.length() && json.charAt(end) != ',' && json.charAt(end) != '}' && json.charAt(end) != ']' && json.charAt(end) > ' ') end++;
        String token = json.substring(start, end).trim();
        if ("true".equals(token) || "false".equals(token)) return new ParseResult(Boolean.parseBoolean(token), end);
        if ("null".equals(token)) return new ParseResult(null, end);
        return new ParseResult(token.contains(".") ? Double.parseDouble(token) : Long.parseLong(token), end);
    }

    private static int findMatchingClose(String s, int start, char open, char close) {
        int depth = 0;
        boolean inStr = false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStr) {
                if (c == '\\') i++;
                else if (c == '"') inStr = false;
            } else {
                if (c == '"') inStr = true;
                else if (c == open) depth++;
                else if (c == close) { depth--; if (depth == 0) return i; }
            }
        }
        throw new RuntimeException("Unmatched bracket");
    }

    private static class ParseResult {
        Object value;
        int endIndex;
        ParseResult(Object value, int endIndex) { this.value = value; this.endIndex = endIndex; }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T> T convert(Object value, Class<T> clazz) {
        if (value == null) return null;

        if (clazz == String.class) return (T) value.toString();
        if (clazz == int.class || clazz == Integer.class) return (T) Integer.valueOf(((Number) value).intValue());
        if (clazz == long.class || clazz == Long.class) return (T) Long.valueOf(((Number) value).longValue());
        if (clazz == double.class || clazz == Double.class) return (T) Double.valueOf(((Number) value).doubleValue());
        if (clazz == boolean.class || clazz == Boolean.class) return (T) value;
        if (clazz == LocalDateTime.class) return (T) LocalDateTime.parse(value.toString(), ISO_FORMAT);
        if (Enum.class.isAssignableFrom(clazz)) return (T) Enum.valueOf((Class<Enum>) clazz, value.toString());

        if (value instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) value;
            T instance;
            try {
                instance = clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Cannot instantiate " + clazz.getName(), e);
            }
            for (Field field : getAllFields(clazz)) {
                field.setAccessible(true);
                if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) continue;
                String name = fieldName(field);
                Object fieldValue = map.get(name);
                if (fieldValue == null) continue;

                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) genericType;
                    Class<?> rawType = (Class<?>) pt.getRawType();
                    if (List.class.isAssignableFrom(rawType) && fieldValue instanceof List) {
                        Class<?> itemType = (Class<?>) pt.getActualTypeArguments()[0];
                        List<Object> resultList = new ArrayList<>();
                        for (Object item : (List<?>) fieldValue) {
                            resultList.add(convert(item, itemType));
                        }
                        try { field.set(instance, resultList); } catch (IllegalAccessException ignored) {}
                        continue;
                    }
                    if (Map.class.isAssignableFrom(rawType) && fieldValue instanceof Map) {
                        try { field.set(instance, fieldValue); } catch (IllegalAccessException ignored) {}
                        continue;
                    }
                }

                try {
                    field.set(instance, convert(fieldValue, field.getType()));
                } catch (IllegalAccessException ignored) {}
            }
            return instance;
        }

        if (value instanceof List && clazz.isArray()) {
            List<?> list = (List<?>) value;
            Class<?> componentType = clazz.getComponentType();
            Object[] arr = (Object[]) java.lang.reflect.Array.newInstance(componentType, list.size());
            for (int i = 0; i < list.size(); i++) {
                arr[i] = convert(list.get(i), componentType);
            }
            return (T) arr;
        }

        return (T) value;
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
