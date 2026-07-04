package br.com.cabrapi.sdk.model.product;

import br.com.cabrapi.sdk.model.common.Pagination;
import java.util.List;

public class GetProductsResponse {
    private boolean status;
    private String code;
    private List<Product> products;
    private Pagination pagination;

    public GetProductsResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    public Pagination getPagination() { return pagination; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
}
