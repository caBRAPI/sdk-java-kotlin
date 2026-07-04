package br.com.cabrapi.sdk.model.payment;

public class CreatePaymentItem {
    private String productId;
    private int quantity;

    public CreatePaymentItem() {}

    public CreatePaymentItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
