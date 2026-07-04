package br.com.cabrapi.sdk.model.store;

import java.util.List;

public class StoreDetails extends Store {
    private String ownerId;
    private String deletedAt;
    private List<Object> categories;
    private List<Object> products;
    private List<Object> coupons;
    private List<Object> payment;

    public StoreDetails() {}

    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public String getDeletedAt() { return deletedAt; }
    public void setDeletedAt(String deletedAt) { this.deletedAt = deletedAt; }
    public List<Object> getCategories() { return categories; }
    public void setCategories(List<Object> categories) { this.categories = categories; }
    public List<Object> getProducts() { return products; }
    public void setProducts(List<Object> products) { this.products = products; }
    public List<Object> getCoupons() { return coupons; }
    public void setCoupons(List<Object> coupons) { this.coupons = coupons; }
    public List<Object> getPayment() { return payment; }
    public void setPayment(List<Object> payment) { this.payment = payment; }
}
