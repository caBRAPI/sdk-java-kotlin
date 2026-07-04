package examples.coupons;

import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.coupon.*;
import java.util.*;

/**
 * Example demonstrating how to use the Coupons module.
 * <p>
 * Covers all CRUD operations plus lookup by code and reorder:
 * <ul>
 *   <li>{@code GET /stores/:storeId/coupons}</li>
 *   <li>{@code GET /stores/:storeId/coupons/:code} (public)</li>
 *   <li>{@code GET /stores/:storeId/coupons/uuid/:couponId}</li>
 *   <li>{@code POST /stores/:storeId/coupons}</li>
 *   <li>{@code PUT /stores/:storeId/coupons/:couponId}</li>
 *   <li>{@code PUT /stores/:storeId/coupons/reorder}</li>
 *   <li>{@code DELETE /stores/:storeId/coupons/:couponId}</li>
 * </ul>
 */
public class Coupons {
    public static void main(String[] args) throws Exception {
        caBRAPI api = new caBRAPI(new CoreClient.Options(CoreClient.Mode.PRIVATE)
            .apiKey(System.getenv("CABRAPI_KEY")));

        String storeId = "3b751276-101d-48ba-8fb1-bb8e4bbf4277";

        // GET /stores/:storeId/coupons
        GetCouponsResponse list = api.coupons().get(storeId, new GetCouponsRequest(1, 20));
        System.out.println("Cupons: " + list.getCoupons());

        // GET /stores/:storeId/coupons/:code (public)
        GetCouponByCodeResponse byCode = api.coupons().getByCode(storeId, "BEMVINDO10");
        System.out.println("Cupom por codigo: " + byCode.getCoupon());

        // GET /stores/:storeId/coupons/uuid/:couponId
        GetCouponByIdResponse byId = api.coupons().getById(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036");
        System.out.println("Cupom por ID: " + byId.getCoupon());

        // POST /stores/:storeId/coupons
        CreateCouponRequest createReq = new CreateCouponRequest("BEMVINDO10", 10);
        createReq.setUseLimit(-1);
        createReq.setProductIds(Arrays.asList("71b1abcf-54dd-4003-958b-4bd67c936036"));
        CreateCouponResponse created = api.coupons().create(storeId, createReq);
        System.out.println("Criado: " + created.getCoupon());

        // PUT /stores/:storeId/coupons/:couponId
        UpdateCouponRequest updateReq = new UpdateCouponRequest();
        updateReq.setDiscount(15);
        updateReq.setUseLimit(200);
        UpdateCouponResponse updated = api.coupons().update(storeId, "71b1abcf-54dd-4003-958b-4bd67c936036", updateReq);
        System.out.println("Atualizado: " + updated.getCoupon());

        // PUT /stores/:storeId/coupons/reorder
        ReorderCouponsResponse reorder = api.coupons().reorder(storeId, Arrays.asList(
            "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1",
            "a6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a2"));
        System.out.println("Reordenado: " + reorder.isStatus());

        // DELETE /stores/:storeId/coupons/:couponId
        DeleteCouponResponse deleted = api.coupons().delete(storeId, "c6f0d28a-8ce2-4a8f-9771-4df1f2a7f3a1");
        System.out.println("Deletado: " + deleted.isStatus());
    }
}
