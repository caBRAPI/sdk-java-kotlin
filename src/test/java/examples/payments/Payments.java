package examples.payments;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.payment.*;
import java.util.*;

public class Payments {

    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    static caBRAPI client() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PUBLIC));
    }

    public static void main(String[] args) throws Exception {

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";
        String paymentId = "71b1abcf-54dd-4003-958b-4bd67c936036";

        // ──────────────────────────────────────────────
        // CLIENT-SIDE (publico)
        // ──────────────────────────────────────────────

        caBRAPI pub = client();

        // POST /stores/:storeId/payments (public)
        CreatePaymentRequest createReq = new CreatePaymentRequest();
        createReq.setName("Joao Silva");
        createReq.setEmail("joao@email.com");
        createReq.setCpf("12345678909");
        createReq.setGateway(PaymentCreateGateway.MERCADOPAGO_SERVICE_PIX);
        createReq.setCoupon("BEMVINDO10");
        createReq.setItems(Arrays.asList(new CreatePaymentItem("c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1", 1)));
        HttpResponse created = pub.payments().create(storeId, createReq);
        System.out.println("POST /stores/:id/payments (public): " + created.getBody());

        // ──────────────────────────────────────────────
        // SERVER-SIDE (requer API key)
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // GET /stores/:storeId/payments
        HttpResponse list = api.payments().get(storeId, new GetPaymentsRequest(1, 20));
        System.out.println("GET /stores/:id/payments: " + list.getBody());

        // GET /stores/:storeId/payments/filter
        FilterPaymentsRequest filterReq = new FilterPaymentsRequest();
        filterReq.setGateway(PaymentGateway.MERCADOPAGO);
        filterReq.setStatus(PaymentStatus.APPROVED);
        filterReq.setSortBy(PaymentSortBy.createdAt);
        filterReq.setSortOrder(PaymentSortOrder.desc);
        filterReq.setPage(1);
        filterReq.setLimit(10);
        HttpResponse filtered = api.payments().filter(storeId, filterReq);
        System.out.println("GET /stores/:id/payments/filter: " + filtered.getBody());

        // PUT /stores/:storeId/payments/:paymentId
        UpdatePaymentRequest updateReq = new UpdatePaymentRequest();
        updateReq.setShipment(PaymentShipmentStatus.SHIPPED);
        HttpResponse updated = api.payments().update(storeId, paymentId, updateReq);
        System.out.println("PUT /stores/:id/payments/:pid: " + updated.getBody());

        // DELETE /stores/:storeId/payments/:paymentId
        HttpResponse deleted = api.payments().delete(storeId, paymentId);
        System.out.println("DELETE /stores/:id/payments/:pid: " + deleted.getBody());
    }
}
