package br.com.cabrapi.sdk.model.payment;

import br.com.cabrapi.sdk.model.common.Pagination;
import java.util.List;

public class GetPaymentsResponse {
    private boolean status;
    private String code;
    private List<Payment> payments;
    private Pagination pagination;

    public GetPaymentsResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }
    public Pagination getPagination() { return pagination; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
}
