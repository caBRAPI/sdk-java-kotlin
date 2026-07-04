package examples.products;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.product.*;
import java.util.*;

/**
 * Example demonstrating how to use the Products module.
 * <p>
 * Covers all CRUD operations plus category-based listing and reorder:
 * <ul>
 *   <li>{@code GET /stores/:storeId/products} (public)</li>
 *   <li>{@code GET /stores/:storeId/products/:productId} (public)</li>
 *   <li>{@code GET /stores/:storeId/categories/:categoryId/products} (public)</li>
 *   <li>{@code POST /stores/:storeId/products}</li>
 *   <li>{@code PUT /stores/:storeId/products/:productId}</li>
 *   <li>{@code PUT /stores/:storeId/products/reorder}</li>
 *   <li>{@code DELETE /stores/:storeId/products/:productId}</li>
 * </ul>
 */
public class Products {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";

        // GET /stores/:storeId/products (public)
        GetProductsResponse list = api.products().get(storeId, new GetProductsRequest(1, 20));
        System.out.println("Produtos: " + list.getProducts());

        // GET /stores/:storeId/products/:productId (public)
        GetProductByIdResponse byId = api.products().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("Produto: " + byId.getProduct());

        // GET /stores/:storeId/categories/:categoryId/products (public)
        GetProductsResponse byCat = api.products().getByCategory(storeId,
            "71b1abcf-54dd-4003-958b-4bd67c936036", new GetProductsRequest(1, 20));
        System.out.println("Produtos por categoria: " + byCat.getProducts());

        // POST /stores/:storeId/products
        CreateProductRequest createReq = new CreateProductRequest("Curso Premium", ProductDelivery.DIGITAL, 49.9);
        createReq.setDescription("Acesso completo ao conteudo.");
        createReq.setImage("https://example.com/product.png");
        createReq.setCategoryIds(Arrays.asList("71b1abcf-54dd-4003-958b-4bd67c936036"));
        createReq.setStock(100);
        createReq.setDisabled(false);
        CreateProductResponse created = api.products().create(storeId, createReq);
        System.out.println("Criado: " + created.getProduct());

        // PUT /stores/:storeId/products/:productId
        UpdateProductRequest updateReq = new UpdateProductRequest();
        updateReq.setName("Curso Premium Atualizado");
        updateReq.setPrice(59.9);
        updateReq.setStock(80);
        updateReq.setDisabled(true);
        updateReq.setPosition(2);
        UpdateProductResponse updated = api.products().update(storeId,
            "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("Atualizado: " + updated.getProduct());

        // PUT /stores/:storeId/products/reorder
        ReorderProductsResponse reorder = api.products().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("Reordenado: " + reorder.isStatus());

        // DELETE /stores/:storeId/products/:productId
        DeleteProductResponse deleted = api.products().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("Deletado: " + deleted.isStatus());
    }
}
