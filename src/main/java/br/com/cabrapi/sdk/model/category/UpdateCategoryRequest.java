package br.com.cabrapi.sdk.model.category;

import java.util.Map;

public class UpdateCategoryRequest {
    private String name;
    private String description;
    private String image;
    private Map<String, Object> metadata;
    private Integer position;

    public UpdateCategoryRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}
