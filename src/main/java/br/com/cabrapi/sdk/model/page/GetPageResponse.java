package br.com.cabrapi.sdk.model.page;

public class GetPageResponse {
    private boolean status;
    private Page data;

    public GetPageResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public Page getData() { return data; }
    public void setData(Page data) { this.data = data; }
}
