package br.com.cabrapi.sdk.model.coupon;

import java.util.List;

public class Coupon {
    private String id;
    private String code;
    private int position;
    private int discount;
    private int useLimit;
    private String expiredAt;
    private String storeId;
    private List<CouponRelationRef> products;
    private List<CouponRelationRef> categories;
    private String createdAt;
    private String updatedAt;

    public Coupon() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }
    public int getUseLimit() { return useLimit; }
    public void setUseLimit(int useLimit) { this.useLimit = useLimit; }
    public String getExpiredAt() { return expiredAt; }
    public void setExpiredAt(String expiredAt) { this.expiredAt = expiredAt; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public List<CouponRelationRef> getProducts() { return products; }
    public void setProducts(List<CouponRelationRef> products) { this.products = products; }
    public List<CouponRelationRef> getCategories() { return categories; }
    public void setCategories(List<CouponRelationRef> categories) { this.categories = categories; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
