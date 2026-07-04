package br.com.cabrapi.sdk.model.payment;

import java.util.Map;

public class UpdatePaymentRequest {
    private PaymentShipmentStatus shipment;
    private Map<String, Object> metadata;

    public UpdatePaymentRequest() {}

    public PaymentShipmentStatus getShipment() { return shipment; }
    public void setShipment(PaymentShipmentStatus shipment) { this.shipment = shipment; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
