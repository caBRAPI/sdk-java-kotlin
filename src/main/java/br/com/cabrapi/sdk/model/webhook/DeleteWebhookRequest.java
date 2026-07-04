package br.com.cabrapi.sdk.model.webhook;

public class DeleteWebhookRequest {
    private String url;

    public DeleteWebhookRequest() {}

    public DeleteWebhookRequest(String url) {
        this.url = url;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
