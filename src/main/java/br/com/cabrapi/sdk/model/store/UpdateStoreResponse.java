package br.com.cabrapi.sdk.model.store;

public class UpdateStoreResponse {
    private boolean status;
    private String code;
    private Store store;

    public UpdateStoreResponse() {}

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
