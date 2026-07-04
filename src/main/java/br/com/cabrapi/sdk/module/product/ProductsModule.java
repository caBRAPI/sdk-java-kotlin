package br.com.cabrapi.sdk.module.product;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.product.*;

import java.util.*;

public class ProductsModule {

    private final CoreClient core;

    public ProductsModule(CoreClient core) {
        this.core = core;
    }

    public HttpResponse get(String storeId, GetProductsRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        return core.getHttp().get("/stores/" + storeId + "/products", params.isEmpty() ? null : params);
    }

    public HttpResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public HttpResponse getByCategory(String storeId, String categoryId, GetProductsRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        return core.getHttp().get("/stores/" + storeId + "/categories/" + categoryId + "/products", params.isEmpty() ? null : params);
    }

    public HttpResponse getByCategory(String storeId, String categoryId) throws Exception {
        return getByCategory(storeId, categoryId, null);
    }

    public HttpResponse getById(String storeId, String productId) throws Exception {
        return core.getHttp().get("/stores/" + storeId + "/products/" + productId);
    }

    public HttpResponse create(String storeId, CreateProductRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().post("/stores/" + storeId + "/products", input);
    }

    public HttpResponse update(String storeId, String productId, UpdateProductRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().put("/stores/" + storeId + "/products/" + productId, input);
    }

    public HttpResponse delete(String storeId, String productId) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/stores/" + storeId + "/products/" + productId);
    }

    public HttpResponse reorder(String storeId, List<String> productIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("productIds", productIds);
        return core.getHttp().put("/stores/" + storeId + "/products/reorder", body);
    }
}
