package examples.categories;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.category.*;
import java.util.*;

public class Categories {

    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    static caBRAPI client() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PUBLIC));
    }

    public static void main(String[] args) throws Exception {

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";

        // ──────────────────────────────────────────────
        // CLIENT-SIDE (publico)
        // ──────────────────────────────────────────────

        caBRAPI pub = client();

        // GET /stores/:storeId/categories
        HttpResponse list = pub.categories().get(storeId, new GetCategoriesRequest(1, 20));
        System.out.println("GET /stores/:id/categories: " + list.getBody());

        // GET /stores/:storeId/categories/:categoryId
        HttpResponse byId = pub.categories().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("GET /stores/:id/categories/:cid: " + byId.getBody());

        // ──────────────────────────────────────────────
        // SERVER-SIDE (requer API key)
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // POST /stores/:storeId/categories
        CreateCategoryRequest createReq = new CreateCategoryRequest();
        createReq.setName("Eletronicos");
        createReq.setDescription("Produtos eletronicos em geral");
        createReq.setImage("https://example.com/category.png");
        HttpResponse created = api.categories().create(storeId, createReq);
        System.out.println("POST /stores/:id/categories: " + created.getBody());

        // PUT /stores/:storeId/categories/:categoryId
        UpdateCategoryRequest updateReq = new UpdateCategoryRequest();
        updateReq.setName("Eletronicos Premium");
        updateReq.setPosition(2);
        HttpResponse updated = api.categories().update(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("PUT /stores/:id/categories/:cid: " + updated.getBody());

        // PUT /stores/:storeId/categories/reorder
        HttpResponse reorder = api.categories().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("PUT /stores/:id/categories/reorder: " + reorder.getBody());

        // DELETE /stores/:storeId/categories/:categoryId
        HttpResponse deleted = api.categories().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("DELETE /stores/:id/categories/:cid: " + deleted.getBody());
    }
}
