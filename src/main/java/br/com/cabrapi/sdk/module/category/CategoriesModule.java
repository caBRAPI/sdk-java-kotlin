package br.com.cabrapi.sdk.module.category;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.category.*;

import java.util.*;

public class CategoriesModule {

    private final CoreClient core;

    public CategoriesModule(CoreClient core) {
        this.core = core;
    }

    public HttpResponse get(String storeId, GetCategoriesRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        return core.getHttp().get("/stores/" + storeId + "/categories", params.isEmpty() ? null : params);
    }

    public HttpResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public HttpResponse getById(String storeId, String categoryId) throws Exception {
        return core.getHttp().get("/stores/" + storeId + "/categories/" + categoryId);
    }

    public HttpResponse create(String storeId, CreateCategoryRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().post("/stores/" + storeId + "/categories", input);
    }

    public HttpResponse update(String storeId, String categoryId, UpdateCategoryRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().put("/stores/" + storeId + "/categories/" + categoryId, input);
    }

    public HttpResponse delete(String storeId, String categoryId) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/stores/" + storeId + "/categories/" + categoryId);
    }

    public HttpResponse reorder(String storeId, List<String> categoryIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("categoryIds", categoryIds);
        return core.getHttp().put("/stores/" + storeId + "/categories/reorder", body);
    }
}
