package br.com.cabrapi.sdk.model.webhook;

public class CreateWebhookResponse {
    private boolean status;
    private String code;
    private String webhook;

    public CreateWebhookResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getWebhook() { return webhook; }
    public void setWebhook(String webhook) { this.webhook = webhook; }
}
