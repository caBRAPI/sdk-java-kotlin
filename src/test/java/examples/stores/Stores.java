package examples.stores;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.store.*;
import java.util.*;

/**
 * Example demonstrating how to use the Stores module.
 * <p>
 * Covers all CRUD operations plus reorder:
 * <ul>
 *   <li>{@code GET /stores}</li>
 *   <li>{@code GET /stores/:storeId}</li>
 *   <li>{@code POST /stores}</li>
 *   <li>{@code PUT /stores/:storeId}</li>
 *   <li>{@code PUT /stores/reorder}</li>
 *   <li>{@code DELETE /stores/:storeId}</li>
 * </ul>
 */
public class Stores {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        // GET /stores
        GetStoresResponse list = api.stores().get(new GetStoresRequest(1, 10));
        System.out.println("Lojas: " + list.getStores());

        // GET /stores/:storeId
        GetStoreByIdResponse store = api.stores().getById("b23a64ee-762b-4bf4-89fa-953ab4e2ac71");
        System.out.println("Loja: " + store.getStore());

        // POST /stores
        CreateStoreRequest createReq = new CreateStoreRequest(StoreTemplate.PERSONALIZADO);
        createReq.setName("Minha Loja");
        createReq.setDescription("Descricao da minha loja para teste");
        createReq.setImage("https://example.com/store.png");
        createReq.setDomain(new StoreDomainInput(StoreDomainType.DEFAULT, "minha-loja-teste"));
        CreateStoreResponse created = api.stores().create(createReq);
        System.out.println("Criada: " + created.getStore());

        // PUT /stores/:storeId
        UpdateStoreRequest updateReq = new UpdateStoreRequest();
        updateReq.setName("caBRAPI");
        updateReq.setDescription("Descricao atualizada");
        UpdateStoreResponse updated = api.stores().update("b23a64ee-762b-4bf4-89fa-953ab4e2ac71", updateReq);
        System.out.println("Atualizada: " + updated.getStore());

        // PUT /stores/reorder
        ReorderStoresResponse reorder = api.stores().reorder(Arrays.asList(
            "b23a64ee-762b-4bf4-89fa-953ab4e2ac71",
            "f3e4bcb8-4c46-43a4-9bff-bb24c7649d61"));
        System.out.println("Reordenado: " + reorder.isStatus());

        // DELETE /stores/:storeId
        DeleteStoreResponse deleted = api.stores().delete("b23a64ee-762b-4bf4-89fa-953ab4e2ac71");
        System.out.println("Deletado: " + deleted.isStatus());
    }
}
