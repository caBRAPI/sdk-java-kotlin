package examples.webhooks;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.webhook.*;
import java.util.Map;

public class Webhooks {

    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    // Webhooks nao possui endpoints publicos

    public static void main(String[] args) throws Exception {

        String storeId = "b23a64ee-762b-4bf4-89fa-953ab4e2ac71";

        // ──────────────────────────────────────────────
        // SERVER-SIDE
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // GET /stores/:storeId/webhooks
        HttpResponse list = api.webhooks().get(storeId);
        System.out.println("GET /stores/:id/webhooks: " + list.getBody());

        // POST /stores/:storeId/webhooks
        HttpResponse created = api.webhooks().create(storeId,
            new CreateWebhookRequest("https://meusistema.com/callback"));
        System.out.println("POST /stores/:id/webhooks: " + created.getBody());

        // DELETE /stores/:storeId/webhooks
        HttpResponse deleted = api.webhooks().delete(storeId,
            new DeleteWebhookRequest("https://meusistema.com/callback"));
        System.out.println("DELETE /stores/:id/webhooks: " + deleted.getBody());

        // ──────────────────────────────────────────────
        // DECRYPT (utilitario, nao é endpoint)
        // ──────────────────────────────────────────────

        String secret = System.getenv("CABRAPI_KEY");
        String encryptedPayload = System.getenv("WEBHOOK_PAYLOAD");
        if (secret != null && encryptedPayload != null && !encryptedPayload.isEmpty()) {
            Map<String, Object> parsed = api.webhooks().decrypt(secret, encryptedPayload);
            System.out.println("Decrypted payload: " + parsed);
        }
    }
}
