package br.com.cabrapi.sdk.model.product;

public class UpdateProductResponse {
    private boolean status;
    private String code;
    private Product product;

    public UpdateProductResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
