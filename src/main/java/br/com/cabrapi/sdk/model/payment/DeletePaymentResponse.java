package br.com.cabrapi.sdk.model.payment;

public class DeletePaymentResponse {
    private boolean status;
    private String code;
    private String message;

    public DeletePaymentResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
