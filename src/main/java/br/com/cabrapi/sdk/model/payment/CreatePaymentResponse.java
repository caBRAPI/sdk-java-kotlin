package br.com.cabrapi.sdk.model.payment;

import java.util.Map;

public class CreatePaymentResponse {
    private boolean status;
    private Data data;

    public CreatePaymentResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public static class Data {
        private Service service;
        private PaymentData payment;

        public Service getService() { return service; }
        public void setService(Service service) { this.service = service; }
        public PaymentData getPayment() { return payment; }
        public void setPayment(PaymentData payment) { this.payment = payment; }
    }

    public static class Service {
        private String type;
        private String method;
        private String payment;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getMethod() { return method; }
        public void setMethod(String method) { this.method = method; }
        public String getPayment() { return payment; }
        public void setPayment(String payment) { this.payment = payment; }
    }

    public static class PaymentData {
        private String uuid;
        private String url;
        private QrCode qrCode;

        public String getUuid() { return uuid; }
        public void setUuid(String uuid) { this.uuid = uuid; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public QrCode getQrCode() { return qrCode; }
        public void setQrCode(QrCode qrCode) { this.qrCode = qrCode; }

        public static class QrCode {
            private String image;
            private String base64;

            public String getImage() { return image; }
            public void setImage(String image) { this.image = image; }
            public String getBase64() { return base64; }
            public void setBase64(String base64) { this.base64 = base64; }
        }
    }
}
