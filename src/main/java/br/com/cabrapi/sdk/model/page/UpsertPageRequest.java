package br.com.cabrapi.sdk.model.page;

public class UpsertPageRequest {
    private String domain;
    private String html;
    private String template;

    public UpsertPageRequest() {}

    public UpsertPageRequest(String domain, String html) {
        this.domain = domain;
        this.html = html;
    }

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public String getHtml() { return html; }
    public void setHtml(String html) { this.html = html; }
    public String getTemplate() { return template; }
    public void setTemplate(String template) { this.template = template; }
}
