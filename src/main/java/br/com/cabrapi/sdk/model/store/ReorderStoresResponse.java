package br.com.cabrapi.sdk.model.store;

public class ReorderStoresResponse {
    private boolean status;
    private String code;

    public ReorderStoresResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
