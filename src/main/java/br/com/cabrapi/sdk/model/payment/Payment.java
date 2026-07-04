package br.com.cabrapi.sdk.model.payment;

import java.util.Map;

public class Payment {
    private String id;
    private String uuid;
    private PaymentStatus status;
    private String name;
    private String email;
    private String cpf;
    private Double price;
    private PaymentGateway gateway;
    private PaymentShipmentStatus shipment;
    private String storeId;
    private Map<String, Object> metadata;

    public Payment() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public PaymentGateway getGateway() { return gateway; }
    public void setGateway(PaymentGateway gateway) { this.gateway = gateway; }
    public PaymentShipmentStatus getShipment() { return shipment; }
    public void setShipment(PaymentShipmentStatus shipment) { this.shipment = shipment; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
