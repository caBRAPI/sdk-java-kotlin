package br.com.cabrapi.sdk.model.store;

import br.com.cabrapi.sdk.model.common.Pagination;
import java.util.List;

public class GetStoresResponse {
    private boolean status;
    private String code;
    private List<Store> stores;
    private Pagination pagination;

    public GetStoresResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<Store> getStores() { return stores; }
    public void setStores(List<Store> stores) { this.stores = stores; }
    public Pagination getPagination() { return pagination; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
}
