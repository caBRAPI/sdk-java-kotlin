package br.com.cabrapi.sdk.model.category;

public class GetCategoryByIdResponse {
    private boolean status;
    private String code;
    private CategoryDetails category;

    public GetCategoryByIdResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public CategoryDetails getCategory() { return category; }
    public void setCategory(CategoryDetails category) { this.category = category; }
}
