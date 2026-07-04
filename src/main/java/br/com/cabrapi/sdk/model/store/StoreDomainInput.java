package br.com.cabrapi.sdk.model.store;

public class StoreDomainInput {
    private StoreDomainType type;
    private String value;

    public StoreDomainInput() {}

    public StoreDomainInput(StoreDomainType type, String value) {
        this.type = type;
        this.value = value;
    }

    public StoreDomainType getType() { return type; }
    public void setType(StoreDomainType type) { this.type = type; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
