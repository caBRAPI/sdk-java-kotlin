package br.com.cabrapi.sdk.model.category;

public class GetCategoriesRequest {
    private Integer page;
    private Integer limit;

    public GetCategoriesRequest() {}

    public GetCategoriesRequest(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
