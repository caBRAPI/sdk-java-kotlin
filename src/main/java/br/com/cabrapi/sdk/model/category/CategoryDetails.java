package br.com.cabrapi.sdk.model.category;

import java.util.List;

public class CategoryDetails extends Category {
    private List<Object> products;
    private List<Object> coupons;

    public CategoryDetails() {}

    public List<Object> getProducts() { return products; }
    public void setProducts(List<Object> products) { this.products = products; }
    public List<Object> getCoupons() { return coupons; }
    public void setCoupons(List<Object> coupons) { this.coupons = coupons; }
}
