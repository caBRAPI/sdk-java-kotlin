package br.com.cabrapi.sdk.model.payment;

import java.util.List;
import java.util.Map;

public class CreatePaymentRequest {
    private String name;
    private String email;
    private String cpf;
    private PaymentCreateGateway gateway;
    private String coupon;
    private Map<String, Object> metadata;
    private List<CreatePaymentItem> items;

    public CreatePaymentRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public PaymentCreateGateway getGateway() { return gateway; }
    public void setGateway(PaymentCreateGateway gateway) { this.gateway = gateway; }
    public String getCoupon() { return coupon; }
    public void setCoupon(String coupon) { this.coupon = coupon; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public List<CreatePaymentItem> getItems() { return items; }
    public void setItems(List<CreatePaymentItem> items) { this.items = items; }
}
