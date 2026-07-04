package br.com.cabrapi.sdk.client;

public class CoreClient {

    public enum Mode {
        PUBLIC,
        PRIVATE
    }

    public static class Options {
        private Mode mode;
        private String apiKey;
        private String baseURL;

        public Options(Mode mode) {
            this.mode = mode;
        }

        public Options apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Options baseURL(String baseURL) {
            this.baseURL = baseURL;
            return this;
        }

        public Mode getMode() { return mode; }
        public String getApiKey() { return apiKey; }
        public String getBaseURL() { return baseURL; }
    }

    private final HttpClient http;
    private final Mode mode;

    public CoreClient(Options options) {
        this.mode = options.getMode();
        this.http = new HttpClient(
            options.getBaseURL(),
            options.getApiKey(),
            HttpClient.DEFAULT_TIMEOUT
        );
        validate(options);
    }

    private void validate(Options options) {
        if (mode == Mode.PRIVATE && (options.getApiKey() == null || options.getApiKey().isEmpty())) {
            throw new IllegalArgumentException("API key é obrigatória no modo PRIVATE.");
        }
    }

    public boolean isPrivate() {
        return mode == Mode.PRIVATE;
    }

    public boolean isPublic() {
        return mode == Mode.PUBLIC;
    }

    public void assertPrivate() {
        if (!isPrivate()) {
            throw new IllegalStateException("Este método é privado e não pode ser usado no modo público.");
        }
    }

    public HttpClient getHttp() {
        return http;
    }
}
