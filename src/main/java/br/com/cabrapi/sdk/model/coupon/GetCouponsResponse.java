package br.com.cabrapi.sdk.model.coupon;

import br.com.cabrapi.sdk.model.common.Pagination;
import java.util.List;

public class GetCouponsResponse {
    private boolean status;
    private String code;
    private List<Coupon> coupons;
    private Pagination pagination;

    public GetCouponsResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<Coupon> getCoupons() { return coupons; }
    public void setCoupons(List<Coupon> coupons) { this.coupons = coupons; }
    public Pagination getPagination() { return pagination; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
}
