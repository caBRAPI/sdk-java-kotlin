package br.com.cabrapi.sdk.model.webhook;

public class CreateWebhookRequest {
    private String url;

    public CreateWebhookRequest() {}

    public CreateWebhookRequest(String url) {
        this.url = url;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
