package br.com.cabrapi.sdk.module.webhook;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.webhook.*;
import br.com.cabrapi.sdk.util.Json;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class WebhooksModule {

    private final CoreClient core;

    public WebhooksModule(CoreClient core) {
        this.core = core;
    }

    public HttpResponse get(String storeId) throws Exception {
        core.assertPrivate();
        return core.getHttp().get("/stores/" + storeId + "/webhooks");
    }

    public HttpResponse create(String storeId, CreateWebhookRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().post("/stores/" + storeId + "/webhooks", input);
    }

    public HttpResponse delete(String storeId, DeleteWebhookRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/stores/" + storeId + "/webhooks", input);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> decrypt(String secret, String payload) throws Exception {
        if (secret == null || secret.isEmpty()) {
            throw new IllegalArgumentException("SECRET_KEY_REQUIRED");
        }
        if (payload == null || !payload.contains(":")) {
            throw new IllegalArgumentException("INVALID_PAYLOAD_FORMAT");
        }

        String[] parts = payload.split(":", 2);
        String ivB64 = parts[0];
        String encrypted = parts[1];

        byte[] iv = Base64.getDecoder().decode(ivB64);
        byte[] encryptedBytes = Base64.getDecoder().decode(encrypted);

        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] keyHash = sha256.digest(secret.getBytes(StandardCharsets.UTF_8));

        SecretKeySpec keySpec = new SecretKeySpec(keyHash, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decrypted = new String(decryptedBytes, StandardCharsets.UTF_8);

        return Json.fromJson(decrypted, LinkedHashMap.class);
    }
}
