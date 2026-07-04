package br.com.cabrapi.sdk.model.category;

import br.com.cabrapi.sdk.model.common.Pagination;
import java.util.List;

public class GetCategoriesResponse {
    private boolean status;
    private String code;
    private List<Category> categories;
    private Pagination pagination;

    public GetCategoriesResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
    public Pagination getPagination() { return pagination; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
}
