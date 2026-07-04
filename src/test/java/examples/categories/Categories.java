package examples.categories;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.category.*;
import java.util.*;

/**
 * Example demonstrating how to use the Categories module.
 * <p>
 * Covers all CRUD operations plus reorder:
 * <ul>
 *   <li>{@code GET /stores/:storeId/categories}</li>
 *   <li>{@code GET /stores/:storeId/categories/:categoryId}</li>
 *   <li>{@code POST /stores/:storeId/categories}</li>
 *   <li>{@code PUT /stores/:storeId/categories/:categoryId}</li>
 *   <li>{@code PUT /stores/:storeId/categories/reorder}</li>
 *   <li>{@code DELETE /stores/:storeId/categories/:categoryId}</li>
 * </ul>
 */
public class Categories {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";

        // GET /stores/:storeId/categories
        GetCategoriesResponse list = api.categories().get(storeId, new GetCategoriesRequest(1, 20));
        System.out.println("Categorias: " + list.getCategories());

        // GET /stores/:storeId/categories/:categoryId
        GetCategoryByIdResponse cat = api.categories().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("Categoria: " + cat.getCategory());

        // POST /stores/:storeId/categories
        CreateCategoryRequest createReq = new CreateCategoryRequest();
        createReq.setName("Eletronicos");
        createReq.setDescription("Produtos eletronicos em geral");
        createReq.setImage("https://example.com/category.png");
        CreateCategoryResponse created = api.categories().create(storeId, createReq);
        System.out.println("Criada: " + created.getCategory());

        // PUT /stores/:storeId/categories/:categoryId
        UpdateCategoryRequest updateReq = new UpdateCategoryRequest();
        updateReq.setName("Eletronicos Premium");
        updateReq.setPosition(2);
        UpdateCategoryResponse updated = api.categories().update(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("Atualizada: " + updated.getCategory());

        // PUT /stores/:storeId/categories/reorder
        ReorderCategoriesResponse reorder = api.categories().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("Reordenado: " + reorder.isStatus());

        // DELETE /stores/:storeId/categories/:categoryId
        DeleteCategoryResponse deleted = api.categories().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("Deletado: " + deleted.isStatus());
    }
}
