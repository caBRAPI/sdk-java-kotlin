package examples.payments;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.payment.*;
import java.util.*;

/**
 * Example demonstrating how to use the Payments module.
 * <p>
 * Covers all CRUD operations plus filtering:
 * <ul>
 *   <li>{@code GET /stores/:storeId/payments}</li>
 *   <li>{@code GET /stores/:storeId/payments/filter}</li>
 *   <li>{@code POST /stores/:storeId/payments} (public)</li>
 *   <li>{@code PUT /stores/:storeId/payments/:paymentId}</li>
 *   <li>{@code DELETE /stores/:storeId/payments/:paymentId}</li>
 * </ul>
 */
public class Payments {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";
        String paymentId = "71b1abcf-54dd-4003-958b-4bd67c936036";

        // GET /stores/:storeId/payments
        GetPaymentsResponse list = api.payments().get(storeId, new GetPaymentsRequest(1, 20));
        System.out.println("Pagamentos: " + list.getPayments());

        // GET /stores/:storeId/payments/filter
        FilterPaymentsRequest filterReq = new FilterPaymentsRequest();
        filterReq.setGateway(PaymentGateway.MERCADOPAGO);
        filterReq.setStatus(PaymentStatus.APPROVED);
        filterReq.setSortBy(PaymentSortBy.createdAt);
        filterReq.setSortOrder(PaymentSortOrder.desc);
        filterReq.setPage(1);
        filterReq.setLimit(10);
        FilterPaymentsResponse filtered = api.payments().filter(storeId, filterReq);
        System.out.println("Filtrados: " + filtered.getPayments());

        // POST /stores/:storeId/payments (public)
        CreatePaymentRequest createReq = new CreatePaymentRequest();
        createReq.setName("Joao Silva");
        createReq.setEmail("joao@email.com");
        createReq.setCpf("12345678909");
        createReq.setGateway(PaymentCreateGateway.MERCADOPAGO_SERVICE_PIX);
        createReq.setCoupon("BEMVINDO10");
        createReq.setItems(Arrays.asList(new CreatePaymentItem("c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1", 1)));
        CreatePaymentResponse created = api.payments().create(storeId, createReq);
        System.out.println("Criado: " + created.getData().getPayment().getUuid());

        // PUT /stores/:storeId/payments/:paymentId
        UpdatePaymentRequest updateReq = new UpdatePaymentRequest();
        updateReq.setShipment(PaymentShipmentStatus.SHIPPED);
        UpdatePaymentResponse updated = api.payments().update(storeId, paymentId, updateReq);
        System.out.println("Atualizado: " + updated.isStatus());

        // DELETE /stores/:storeId/payments/:paymentId
        DeletePaymentResponse deleted = api.payments().delete(storeId, paymentId);
        System.out.println("Deletado: " + deleted.getMessage());
    }
}
