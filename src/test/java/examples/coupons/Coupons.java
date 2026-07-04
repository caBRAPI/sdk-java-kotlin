package examples.coupons;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.coupon.*;
import java.util.*;

public class Coupons {

    static caBRAPI server() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));
    }

    static caBRAPI client() {
        return new caBRAPI(new CoreClient.Options(CoreClient.Mode.PUBLIC));
    }

    public static void main(String[] args) throws Exception {

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";

        // ──────────────────────────────────────────────
        // CLIENT-SIDE (publico)
        // ──────────────────────────────────────────────

        caBRAPI pub = client();

        // GET /stores/:storeId/coupons/:code (public)
        HttpResponse byCode = pub.coupons().getByCode(storeId, "BEMVINDO10");
        System.out.println("GET /stores/:id/coupons/:code (public): " + byCode.getBody());

        // ──────────────────────────────────────────────
        // SERVER-SIDE (requer API key)
        // ──────────────────────────────────────────────

        caBRAPI api = server();

        // GET /stores/:storeId/coupons
        HttpResponse list = api.coupons().get(storeId, new GetCouponsRequest(1, 20));
        System.out.println("GET /stores/:id/coupons: " + list.getBody());

        // GET /stores/:storeId/coupons/uuid/:couponId
        HttpResponse byId = api.coupons().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("GET /stores/:id/coupons/uuid/:cid: " + byId.getBody());

        // POST /stores/:storeId/coupons
        CreateCouponRequest createReq = new CreateCouponRequest("BEMVINDO10", 10);
        createReq.setUseLimit(-1);
        createReq.setProductIds(Arrays.asList("71b1abcf-54dd-4003-958b-4bd67c936036"));
        HttpResponse created = api.coupons().create(storeId, createReq);
        System.out.println("POST /stores/:id/coupons: " + created.getBody());

        // PUT /stores/:storeId/coupons/:couponId
        UpdateCouponRequest updateReq = new UpdateCouponRequest();
        updateReq.setDiscount(15);
        updateReq.setUseLimit(200);
        HttpResponse updated = api.coupons().update(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("PUT /stores/:id/coupons/:cid: " + updated.getBody());

        // PUT /stores/:storeId/coupons/reorder
        HttpResponse reorder = api.coupons().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("PUT /stores/:id/coupons/reorder: " + reorder.getBody());

        // DELETE /stores/:storeId/coupons/:couponId
        HttpResponse deleted = api.coupons().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("DELETE /stores/:id/coupons/:cid: " + deleted.getBody());
    }
}
