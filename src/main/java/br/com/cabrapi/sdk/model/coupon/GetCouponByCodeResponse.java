package br.com.cabrapi.sdk.model.coupon;

public class GetCouponByCodeResponse {
    private boolean status;
    private String code;
    private Coupon coupon;

    public GetCouponByCodeResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Coupon getCoupon() { return coupon; }
    public void setCoupon(Coupon coupon) { this.coupon = coupon; }
}
