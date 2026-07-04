package br.com.cabrapi.sdk.model.store;

public class GetStoreByIdResponse {
    private boolean status;
    private String code;
    private StoreDetails store;

    public GetStoreByIdResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public StoreDetails getStore() { return store; }
    public void setStore(StoreDetails store) { this.store = store; }
}
