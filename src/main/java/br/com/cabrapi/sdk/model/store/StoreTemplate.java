package br.com.cabrapi.sdk.model.store;

public enum StoreTemplate {
    PERSONALIZADO,
    N_A;

    @Override
    public String toString() {
        return this == N_A ? "N/A" : "PERSONALIZADO";
    }
}
