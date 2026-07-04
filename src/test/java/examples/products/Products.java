package examples.products;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.product.*;
import java.util.*;

public class Products {

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

        // GET /stores/:storeId/products
        HttpResponse list = pub.products().get(storeId, new GetProductsRequest(1, 20));
        System.out.println("GET /stores/:id/products: " + list.getBody());

        // GET /stores/:storeId/products/:productId
        HttpResponse byId = pub.products().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("GET /stores/:id/products/:pid: " + byId.getBody());

        // GET /stores/:storeId/categories/:categoryId/products
        HttpResponse byCat = pub.products().getByCategory(storeId,
            "71b1abcf-54dd-4003-958b-4bd67c936036", new GetProductsRequest(1, 20));
        System.out.println("GET /stores/:id/categories/:cid/products: " + byCat.getBody());

        // ──────────────────────────────────────────────
        // SERVER-SIDE (requer API key)
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // POST /stores/:storeId/products
        CreateProductRequest createReq = new CreateProductRequest("Curso Premium", ProductDelivery.DIGITAL, 49.9);
        createReq.setDescription("Acesso completo ao conteudo.");
        createReq.setImage("https://example.com/product.png");
        createReq.setCategoryIds(Arrays.asList("71b1abcf-54dd-4003-958b-4bd67c936036"));
        createReq.setStock(100);
        createReq.setDisabled(false);
        HttpResponse created = api.products().create(storeId, createReq);
        System.out.println("POST /stores/:id/products: " + created.getBody());

        // PUT /stores/:storeId/products/:productId
        UpdateProductRequest updateReq = new UpdateProductRequest();
        updateReq.setName("Curso Premium Atualizado");
        updateReq.setPrice(59.9);
        updateReq.setStock(80);
        updateReq.setDisabled(true);
        updateReq.setPosition(2);
        HttpResponse updated = api.products().update(storeId,
            "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("PUT /stores/:id/products/:pid: " + updated.getBody());

        // PUT /stores/:storeId/products/reorder
        HttpResponse reorder = api.products().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("PUT /stores/:id/products/reorder: " + reorder.getBody());

        // DELETE /stores/:storeId/products/:productId
        HttpResponse deleted = api.products().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("DELETE /stores/:id/products/:pid: " + deleted.getBody());
    }
}
