package examples.webhooks;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.webhook.*;
import java.util.Map;

/**
 * Example demonstrating how to use the Webhooks module.
 * <p>
 * Covers get, create, delete, and payload decryption:
 * <ul>
 *   <li>{@code GET /stores/:storeId/webhooks}</li>
 *   <li>{@code POST /stores/:storeId/webhooks}</li>
 *   <li>{@code DELETE /stores/:storeId/webhooks}</li>
 *   <li>{@code decrypt()} helper</li>
 * </ul>
 */
public class Webhooks {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        String storeId = "b23a64ee-762b-4bf4-89fa-953ab4e2ac71";

        // GET /stores/:storeId/webhooks
        GetWebhooksResponse list = api.webhooks().get(storeId);
        System.out.println("Webhooks: " + list.getWebhooks());

        // POST /stores/:storeId/webhooks
        CreateWebhookResponse created = api.webhooks().create(storeId,
            new CreateWebhookRequest("https://meusistema.com/callback"));
        System.out.println("Criado: " + created.getWebhook());

        // DELETE /stores/:storeId/webhooks
        DeleteWebhookResponse deleted = api.webhooks().delete(storeId,
            new DeleteWebhookRequest("https://meusistema.com/callback"));
        System.out.println("Deletado: " + deleted.isStatus());

        // Decrypt webhook payload using your API key as the secret key
        String secret = System.getenv("CABRAPI_KEY");
        String encryptedPayload = System.getenv("WEBHOOK_PAYLOAD");
        if (secret != null && encryptedPayload != null && !encryptedPayload.isEmpty()) {
            Map<String, Object> parsed = api.webhooks().decrypt(secret, encryptedPayload);
            System.out.println("Decrypted: " + parsed);
        }
    }
}
