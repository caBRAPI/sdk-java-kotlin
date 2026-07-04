package br.com.cabrapi.sdk.model.store;

import java.util.Map;

public class UpdateStoreRequest {
    private StoreTemplate template;
    private String name;
    private String description;
    private String image;
    private Map<String, Object> metadata;
    private StoreDomainInput domain;
    private Integer position;

    public UpdateStoreRequest() {}

    public StoreTemplate getTemplate() { return template; }
    public void setTemplate(StoreTemplate template) { this.template = template; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public StoreDomainInput getDomain() { return domain; }
    public void setDomain(StoreDomainInput domain) { this.domain = domain; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}
