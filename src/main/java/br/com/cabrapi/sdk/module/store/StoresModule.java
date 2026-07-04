package br.com.cabrapi.sdk.module.store;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.store.*;

import java.util.*;

public class StoresModule {

    private final CoreClient core;

    public StoresModule(CoreClient core) {
        this.core = core;
    }

    public GetStoresResponse get(GetStoresRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores", params.isEmpty() ? null : params);
        return res.parse(GetStoresResponse.class);
    }

    public GetStoresResponse get() throws Exception {
        return get(null);
    }

    public GetStoreByIdResponse getById(String storeId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().get("/stores/" + storeId);
        return res.parse(GetStoreByIdResponse.class);
    }

    public CreateStoreResponse create(CreateStoreRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().post("/stores", input);
        return res.parse(CreateStoreResponse.class);
    }

    public UpdateStoreResponse update(String storeId, UpdateStoreRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/stores/" + storeId, input);
        return res.parse(UpdateStoreResponse.class);
    }

    public DeleteStoreResponse delete(String storeId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/stores/" + storeId);
        return res.parse(DeleteStoreResponse.class);
    }

    public ReorderStoresResponse reorder(List<String> storeIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("storeIds", storeIds);
        HttpResponse res = core.getHttp().put("/stores/reorder", body);
        return res.parse(ReorderStoresResponse.class);
    }
}
