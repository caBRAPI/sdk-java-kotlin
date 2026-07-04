package br.com.cabrapi.sdk.module.payment;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.payment.*;

import java.util.*;

public class PaymentsModule {

    private final CoreClient core;

    public PaymentsModule(CoreClient core) {
        this.core = core;
    }

    public GetPaymentsResponse get(String storeId, GetPaymentsRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/payments", params.isEmpty() ? null : params);
        return res.parse(GetPaymentsResponse.class);
    }

    public GetPaymentsResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public FilterPaymentsResponse filter(String storeId, FilterPaymentsRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            putIf(params, "id", input.getId());
            putIf(params, "uuid", input.getUuid());
            putIf(params, "status", input.getStatus());
            putIf(params, "name", input.getName());
            putIf(params, "email", input.getEmail());
            putIf(params, "cpf", input.getCpf());
            putIf(params, "price", input.getPrice());
            putIf(params, "minPrice", input.getMinPrice());
            putIf(params, "maxPrice", input.getMaxPrice());
            putIf(params, "coupon", input.getCoupon());
            putIf(params, "gateway", input.getGateway());
            putIf(params, "shipment", input.getShipment());
            putIf(params, "createdAtFrom", input.getCreatedAtFrom());
            putIf(params, "createdAtTo", input.getCreatedAtTo());
            putIf(params, "updatedAtFrom", input.getUpdatedAtFrom());
            putIf(params, "updatedAtTo", input.getUpdatedAtTo());
            putIf(params, "productId", input.getProductId());
            putIf(params, "metadataKey", input.getMetadataKey());
            putIf(params, "metadataValue", input.getMetadataValue());
            putIf(params, "sortBy", input.getSortBy());
            putIf(params, "sortOrder", input.getSortOrder());
            putIf(params, "page", input.getPage());
            putIf(params, "limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/payments/filter", params.isEmpty() ? null : params);
        return res.parse(FilterPaymentsResponse.class);
    }

    public CreatePaymentResponse create(String storeId, CreatePaymentRequest input) throws Exception {
        HttpResponse res = core.getHttp().post("/stores/" + storeId + "/payments", input);
        return res.parse(CreatePaymentResponse.class);
    }

    public UpdatePaymentResponse update(String storeId, String paymentId, UpdatePaymentRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/payments/" + paymentId, input);
        return res.parse(UpdatePaymentResponse.class);
    }

    public DeletePaymentResponse delete(String storeId, String paymentId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/stores/" + storeId + "/payments/" + paymentId);
        return res.parse(DeletePaymentResponse.class);
    }

    private void putIf(Map<String, Object> map, String key, Object value) {
        if (value != null) map.put(key, value);
    }
}
