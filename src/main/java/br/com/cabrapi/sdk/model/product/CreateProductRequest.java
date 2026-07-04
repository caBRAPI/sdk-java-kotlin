package br.com.cabrapi.sdk.model.product;

import java.util.List;
import java.util.Map;

public class CreateProductRequest {
    private String name;
    private String image;
    private String description;
    private List<String> categoryIds;
    private ProductDelivery delivery;
    private double price;
    private Integer stock;
    private Boolean disabled;
    private Map<String, Object> metadata;

    public CreateProductRequest() {}

    public CreateProductRequest(String name, ProductDelivery delivery, double price) {
        this.name = name;
        this.delivery = delivery;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(List<String> categoryIds) { this.categoryIds = categoryIds; }
    public ProductDelivery getDelivery() { return delivery; }
    public void setDelivery(ProductDelivery delivery) { this.delivery = delivery; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Boolean getDisabled() { return disabled; }
    public void setDisabled(Boolean disabled) { this.disabled = disabled; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
