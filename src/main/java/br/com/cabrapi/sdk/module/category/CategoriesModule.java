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

    public GetCategoriesResponse get(String storeId, GetCategoriesRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/categories", params.isEmpty() ? null : params);
        return res.parse(GetCategoriesResponse.class);
    }

    public GetCategoriesResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public GetCategoryByIdResponse getById(String storeId, String categoryId) throws Exception {
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/categories/" + categoryId);
        return res.parse(GetCategoryByIdResponse.class);
    }

    public CreateCategoryResponse create(String storeId, CreateCategoryRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().post("/stores/" + storeId + "/categories", input);
        return res.parse(CreateCategoryResponse.class);
    }

    public UpdateCategoryResponse update(String storeId, String categoryId, UpdateCategoryRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/categories/" + categoryId, input);
        return res.parse(UpdateCategoryResponse.class);
    }

    public DeleteCategoryResponse delete(String storeId, String categoryId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/stores/" + storeId + "/categories/" + categoryId);
        return res.parse(DeleteCategoryResponse.class);
    }

    public ReorderCategoriesResponse reorder(String storeId, List<String> categoryIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("categoryIds", categoryIds);
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/categories/reorder", body);
        return res.parse(ReorderCategoriesResponse.class);
    }
}
