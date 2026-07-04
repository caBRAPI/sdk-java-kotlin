package br.com.cabrapi.sdk.model.store;

import java.util.Map;

public class Store {
    private String id;
    private String name;
    private int position;
    private String description;
    private String image;
    private String domain;
    private StoreTemplate template;
    private Map<String, Object> metadata;
    private String createdAt;
    private String updatedAt;

    public Store() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public StoreTemplate getTemplate() { return template; }
    public void setTemplate(StoreTemplate template) { this.template = template; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
