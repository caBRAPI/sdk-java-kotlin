package br.com.cabrapi.sdk.client;

import br.com.cabrapi.sdk.util.Json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    public static final String DEFAULT_BASE_URL = "https://api.cabrapi.com.br";
    public static final int DEFAULT_TIMEOUT = 30000;

    private final String baseURL;
    private final String apiKey;
    private final int timeout;

    public HttpClient(String baseURL, String apiKey, int timeout) {
        this.baseURL = baseURL != null ? baseURL : DEFAULT_BASE_URL;
        this.apiKey = apiKey;
        this.timeout = timeout > 0 ? timeout : DEFAULT_TIMEOUT;
    }

    public HttpClient() {
        this(DEFAULT_BASE_URL, null, DEFAULT_TIMEOUT);
    }

    private String buildURL(String path, Map<String, Object> params) {
        if (path.startsWith("http://") || path.startsWith("https://")) {
            return path;
        }
        String url = baseURL.replaceAll("/$", "") + "/" + path.replaceAll("^/", "");
        if (params != null && !params.isEmpty()) {
            StringBuilder qs = new StringBuilder("?");
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        qs.append(URLEncoder.encode(entry.getKey(), "UTF-8"))
                          .append("=")
                          .append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"))
                          .append("&");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            url += qs.substring(0, qs.length() - 1);
        }
        return url;
    }

    private HttpResponse send(String method, String path, Object body, Map<String, Object> params) throws IOException {
        URL url = new URL(buildURL(path, params));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method.toUpperCase());
        conn.setConnectTimeout(timeout);
        conn.setReadTimeout(timeout);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        if (apiKey != null && !apiKey.isEmpty()) {
            conn.setRequestProperty("Authorization", apiKey);
        }
        conn.setDoInput(true);

        if (body != null && !method.equalsIgnoreCase("GET")) {
            conn.setDoOutput(true);
            String json = body instanceof String ? (String) body : Json.toJson(body);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }
        }

        int status = conn.getResponseCode();
        InputStream is = status >= 200 && status < 300 ? conn.getInputStream() : conn.getErrorStream();
        String responseText = "";
        if (is != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int n;
            while ((n = is.read(buf)) != -1) {
                baos.write(buf, 0, n);
            }
            responseText = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        }

        Map<String, String> headers = new HashMap<>();
        conn.getHeaderFields().forEach((key, values) -> {
            if (key != null && values != null && !values.isEmpty()) {
                headers.put(key, String.join(", ", values));
            }
        });

        conn.disconnect();
        return new HttpResponse(status, responseText, headers);
    }

    public HttpResponse get(String path, Map<String, Object> params) throws IOException {
        return send("GET", path, null, params);
    }

    public HttpResponse get(String path) throws IOException {
        return get(path, null);
    }

    public HttpResponse post(String path, Object body) throws IOException {
        return send("POST", path, body, null);
    }

    public HttpResponse put(String path, Object body) throws IOException {
        return send("PUT", path, body, null);
    }

    public HttpResponse delete(String path) throws IOException {
        return send("DELETE", path, null, null);
    }

    public HttpResponse delete(String path, Object body) throws IOException {
        return send("DELETE", path, body, null);
    }

    public static class HttpResponse {
        private final int status;
        private final String body;
        private final Map<String, String> headers;

        public HttpResponse(int status, String body, Map<String, String> headers) {
            this.status = status;
            this.body = body;
            this.headers = headers;
        }

        public int getStatus() { return status; }
        public String getBody() { return body; }
        public Map<String, String> getHeaders() { return headers; }

        public <T> T parse(Class<T> clazz) {
            if (body == null || body.isEmpty()) return null;
            return Json.fromJson(body, clazz);
        }
    }
}
