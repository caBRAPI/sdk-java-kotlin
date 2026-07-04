package br.com.cabrapi.sdk.model.coupon;

import java.util.List;

public class CreateCouponRequest {
    private String code;
    private int discount;
    private Integer useLimit;
    private String expiredAt;
    private List<String> productIds;
    private List<String> categoryIds;

    public CreateCouponRequest() {}

    public CreateCouponRequest(String code, int discount) {
        this.code = code;
        this.discount = discount;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }
    public Integer getUseLimit() { return useLimit; }
    public void setUseLimit(Integer useLimit) { this.useLimit = useLimit; }
    public String getExpiredAt() { return expiredAt; }
    public void setExpiredAt(String expiredAt) { this.expiredAt = expiredAt; }
    public List<String> getProductIds() { return productIds; }
    public void setProductIds(List<String> productIds) { this.productIds = productIds; }
    public List<String> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(List<String> categoryIds) { this.categoryIds = categoryIds; }
}
