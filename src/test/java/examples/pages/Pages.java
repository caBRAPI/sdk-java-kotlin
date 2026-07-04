package examples.pages;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.page.*;

/**
 * Example demonstrating how to use the Pages module.
 * <p>
 * Covers get (public), upsert, and delete:
 * <ul>
 *   <li>{@code GET /pages/:domain} (public)</li>
 *   <li>{@code UPSERT /pages/:domain}</li>
 *   <li>{@code DELETE /pages/:domain}</li>
 * </ul>
 */
public class Pages {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        // GET /pages/:domain (public)
        Page page = api.pages().get("testando-web.cabrapi.com.br");
        System.out.println("Pagina: " + page.getDomain());

        // UPSERT /pages/:domain
        UpsertPageRequest upsertReq = new UpsertPageRequest(
            "testando-web.cabrapi.com.br",
            "<!DOCTYPE html><html><body><h1>Minha Pagina</h1></body></html>");
        upsertReq.setTemplate("DEFAULT");
        UpsertPageResponse upserted = api.pages().upsert(upsertReq);
        System.out.println("Upsert: " + upserted.isStatus());

        // DELETE /pages/:domain
        DeletePageResponse deleted = api.pages().delete("testando-web.cabrapi.com.br");
        System.out.println("Deletado: " + deleted.isStatus());
    }
}
