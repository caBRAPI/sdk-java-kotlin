package br.com.cabrapi.sdk.model.product;

import java.util.List;
import java.util.Map;

public class Product {
    private String id;
    private String name;
    private boolean disabled;
    private int position;
    private String description;
    private double price;
    private String image;
    private ProductDelivery delivery;
    private int stock;
    private int sold;
    private String storeId;
    private Map<String, Object> metadata;
    private String createdAt;
    private String updatedAt;
    private List<ProductCategoryRef> categories;

    public Product() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isDisabled() { return disabled; }
    public void setDisabled(boolean disabled) { this.disabled = disabled; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public ProductDelivery getDelivery() { return delivery; }
    public void setDelivery(ProductDelivery delivery) { this.delivery = delivery; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getSold() { return sold; }
    public void setSold(int sold) { this.sold = sold; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    public List<ProductCategoryRef> getCategories() { return categories; }
    public void setCategories(List<ProductCategoryRef> categories) { this.categories = categories; }
}
