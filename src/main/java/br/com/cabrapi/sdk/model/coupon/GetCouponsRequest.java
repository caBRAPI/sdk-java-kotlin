package br.com.cabrapi.sdk.model.coupon;

public class GetCouponsRequest {
    private Integer page;
    private Integer limit;

    public GetCouponsRequest() {}

    public GetCouponsRequest(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
