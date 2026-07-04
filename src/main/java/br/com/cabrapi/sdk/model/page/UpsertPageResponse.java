package br.com.cabrapi.sdk.model.page;

public class UpsertPageResponse {
    private boolean status;
    private String code;

    public UpsertPageResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
