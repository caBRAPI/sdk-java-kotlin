package br.com.cabrapi.sdk.model.page;

public class Page {
    private String domain;
    private String html;
    private String template;
    private String version;
    private String createdAt;
    private String updatedAt;
    private PageStore store;

    public Page() {}

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public String getHtml() { return html; }
    public void setHtml(String html) { this.html = html; }
    public String getTemplate() { return template; }
    public void setTemplate(String template) { this.template = template; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    public PageStore getStore() { return store; }
    public void setStore(PageStore store) { this.store = store; }

    public static class PageStore {
        private String ownerId;
        private String id;

        public PageStore() {}

        public String getOwnerId() { return ownerId; }
        public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }
}
