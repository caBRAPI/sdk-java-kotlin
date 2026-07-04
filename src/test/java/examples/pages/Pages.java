package examples.pages;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.page.*;

public class Pages {

    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    static caBRAPI client() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PUBLIC));
    }

    public static void main(String[] args) throws Exception {

        // ──────────────────────────────────────────────
        // CLIENT-SIDE (publico)
        // ──────────────────────────────────────────────

        caBRAPI pub = client();

        // GET /pages/:domain (public)
        HttpResponse page = pub.pages().get("theme-light-shop.cabrapi.com.br");
        System.out.println("GET /pages/:domain (public): " + page.getBody());

        // ──────────────────────────────────────────────
        // SERVER-SIDE (requer API key)
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // PUT /pages/:domain (upsert)
        UpsertPageRequest upsertReq = new UpsertPageRequest(
            "theme-light-shop.cabrapi.com.br",
            "<html><body><h1>Minha Loja</h1></body></html>"
        );
        upsertReq.setTemplate("theme-light-shop");
        HttpResponse upserted = api.pages().upsert(upsertReq);
        System.out.println("PUT /pages/:domain (upsert): " + upserted.getBody());

        // DELETE /pages/:domain
        HttpResponse deleted = api.pages().delete("theme-light-shop.cabrapi.com.br");
        System.out.println("DELETE /pages/:domain: " + deleted.getBody());
    }
}
