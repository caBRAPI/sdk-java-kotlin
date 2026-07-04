package examples.stores;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.store.*;
import java.util.*;

public class Stores {

    // SERVER-SIDE (requer CABRAPI_KEY no .env)
    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    // CLIENT-SIDE (publico, sem autenticacao)
    static caBRAPI client() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PUBLIC));
    }

    public static void main(String[] args) throws Exception {

        // ──────────────────────────────────────────────
        // SERVER-SIDE
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // POST /stores
        CreateStoreRequest createReq = new CreateStoreRequest(StoreTemplate.PERSONALIZADO);
        createReq.setName("Minha Loja");
        createReq.setDescription("Descricao da minha loja para teste");
        createReq.setImage("https://example.com/store.png");
        createReq.setDomain(new StoreDomainInput(StoreDomainType.DEFAULT, "minha-loja-teste"));
        HttpResponse created = api.stores().create(createReq);
        System.out.println("POST /stores: " + created.getBody());

        // GET /stores
        HttpResponse list = api.stores().get(new GetStoresRequest(1, 10));
        System.out.println("GET /stores: " + list.getBody());

        // GET /stores/:storeId
        HttpResponse byId = api.stores().getById("b23a64ee-762b-4bf4-89fa-953ab4e2ac71");
        System.out.println("GET /stores/:id: " + byId.getBody());

        // PUT /stores/:storeId
        UpdateStoreRequest updateReq = new UpdateStoreRequest();
        updateReq.setName("caBRAPI");
        updateReq.setDescription("Descricao atualizada");
        HttpResponse updated = api.stores().update("b23a64ee-762b-4bf4-89fa-953ab4e2ac71", updateReq);
        System.out.println("PUT /stores/:id: " + updated.getBody());

        // PUT /stores/reorder
        HttpResponse reorder = api.stores().reorder(Arrays.asList(
            "b23a64ee-762b-4bf4-89fa-953ab4e2ac71",
            "f3e4bcb8-4c46-43a4-9bff-bb24c7649d61"));
        System.out.println("PUT /stores/reorder: " + reorder.getBody());

        // DELETE /stores/:storeId
        HttpResponse deleted = api.stores().delete("b23a64ee-762b-4bf4-89fa-953ab4e2ac71");
        System.out.println("DELETE /stores/:id: " + deleted.getBody());

        // ──────────────────────────────────────────────
        // CLIENT-SIDE (apenas endpoints publicos)
        // ──────────────────────────────────────────────

        caBRAPI pub = client();

        // GET /stores (publico? apenas server-side na real, mas ilustrativo)
        HttpResponse pubList = pub.stores().get(new GetStoresRequest(1, 5));
        System.out.println("GET /stores (public): " + pubList.getBody());
    }
}
