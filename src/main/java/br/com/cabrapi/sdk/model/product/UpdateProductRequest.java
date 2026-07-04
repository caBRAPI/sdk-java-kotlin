package br.com.cabrapi.sdk.model.product;

import java.util.List;
import java.util.Map;

public class UpdateProductRequest {
    private String name;
    private String image;
    private String description;
    private List<String> categoryIds;
    private ProductDelivery delivery;
    private Double price;
    private Integer stock;
    private Boolean disabled;
    private Integer position;
    private Map<String, Object> metadata;

    public UpdateProductRequest() {}

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
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Boolean getDisabled() { return disabled; }
    public void setDisabled(Boolean disabled) { this.disabled = disabled; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
