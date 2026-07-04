package br.com.cabrapi.sdk.model.category;

public class UpdateCategoryResponse {
    private boolean status;
    private String code;
    private Category category;

    public UpdateCategoryResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
