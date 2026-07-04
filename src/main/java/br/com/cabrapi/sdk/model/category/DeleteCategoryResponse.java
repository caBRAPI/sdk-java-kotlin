package br.com.cabrapi.sdk.model.category;

public class DeleteCategoryResponse {
    private boolean status;
    private String code;

    public DeleteCategoryResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
