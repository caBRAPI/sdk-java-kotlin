package br.com.cabrapi.sdk.model.payment;

import java.util.Map;

public class UpdatePaymentResponse {
    private boolean status;
    private String code;
    private UpdatedPayment payment;

    public UpdatePaymentResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public UpdatedPayment getPayment() { return payment; }
    public void setPayment(UpdatedPayment payment) { this.payment = payment; }

    public static class UpdatedPayment {
        private String id;
        private PaymentStatus status;
        private PaymentShipmentStatus shipment;
        private Map<String, Object> metadata;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public PaymentStatus getStatus() { return status; }
        public void setStatus(PaymentStatus status) { this.status = status; }
        public PaymentShipmentStatus getShipment() { return shipment; }
        public void setShipment(PaymentShipmentStatus shipment) { this.shipment = shipment; }
        public Map<String, Object> getMetadata() { return metadata; }
        public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    }
}
