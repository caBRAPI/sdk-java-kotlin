package br.com.cabrapi.sdk.model.store;

public enum StoreDomainType {
    CUSTOM,
    DEFAULT;

    @Override
    public String toString() {
        return name();
    }
}
