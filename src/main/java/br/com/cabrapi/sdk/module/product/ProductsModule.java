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

    public GetProductsResponse get(String storeId, GetProductsRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/products", params.isEmpty() ? null : params);
        return res.parse(GetProductsResponse.class);
    }

    public GetProductsResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public GetProductsResponse getByCategory(String storeId, String categoryId, GetProductsRequest input) throws Exception {
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/categories/" + categoryId + "/products", params.isEmpty() ? null : params);
        return res.parse(GetProductsResponse.class);
    }

    public GetProductsResponse getByCategory(String storeId, String categoryId) throws Exception {
        return getByCategory(storeId, categoryId, null);
    }

    public GetProductByIdResponse getById(String storeId, String productId) throws Exception {
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/products/" + productId);
        return res.parse(GetProductByIdResponse.class);
    }

    public CreateProductResponse create(String storeId, CreateProductRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().post("/stores/" + storeId + "/products", input);
        return res.parse(CreateProductResponse.class);
    }

    public UpdateProductResponse update(String storeId, String productId, UpdateProductRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/products/" + productId, input);
        return res.parse(UpdateProductResponse.class);
    }

    public DeleteProductResponse delete(String storeId, String productId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/stores/" + storeId + "/products/" + productId);
        return res.parse(DeleteProductResponse.class);
    }

    public ReorderProductsResponse reorder(String storeId, List<String> productIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("productIds", productIds);
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/products/reorder", body);
        return res.parse(ReorderProductsResponse.class);
    }
}
