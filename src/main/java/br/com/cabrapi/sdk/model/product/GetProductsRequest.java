package br.com.cabrapi.sdk.model.product;

public class GetProductsRequest {
    private Integer page;
    private Integer limit;

    public GetProductsRequest() {}

    public GetProductsRequest(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
