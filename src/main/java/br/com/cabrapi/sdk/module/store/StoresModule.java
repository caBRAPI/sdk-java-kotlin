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

    public HttpResponse get(GetStoresRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        return core.getHttp().get("/stores", params.isEmpty() ? null : params);
    }

    public HttpResponse get() throws Exception {
        return get(null);
    }

    public HttpResponse getById(String storeId) throws Exception {
        core.assertPrivate();
        return core.getHttp().get("/stores/" + storeId);
    }

    public HttpResponse create(CreateStoreRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().post("/stores", input);
    }

    public HttpResponse update(String storeId, UpdateStoreRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().put("/stores/" + storeId, input);
    }

    public HttpResponse delete(String storeId) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/stores/" + storeId);
    }

    public HttpResponse reorder(List<String> storeIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("storeIds", storeIds);
        return core.getHttp().put("/stores/reorder", body);
    }
}
