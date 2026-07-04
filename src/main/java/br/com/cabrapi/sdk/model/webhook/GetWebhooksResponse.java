package br.com.cabrapi.sdk.model.webhook;

import java.util.List;

public class GetWebhooksResponse {
    private List<String> webhooks;
    private int max;

    public GetWebhooksResponse() {}

    public List<String> getWebhooks() { return webhooks; }
    public void setWebhooks(List<String> webhooks) { this.webhooks = webhooks; }
    public int getMax() { return max; }
    public void setMax(int max) { this.max = max; }
}
