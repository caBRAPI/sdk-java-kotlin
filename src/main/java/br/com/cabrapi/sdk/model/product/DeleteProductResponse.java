package br.com.cabrapi.sdk.model.product;

public class DeleteProductResponse {
    private boolean status;
    private String code;

    public DeleteProductResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
