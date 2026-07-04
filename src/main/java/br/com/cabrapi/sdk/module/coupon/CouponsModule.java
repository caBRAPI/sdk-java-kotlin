package br.com.cabrapi.sdk.module.coupon;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.coupon.*;

import java.util.*;

public class CouponsModule {

    private final CoreClient core;

    public CouponsModule(CoreClient core) {
        this.core = core;
    }

    public GetCouponsResponse get(String storeId, GetCouponsRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/coupons", params.isEmpty() ? null : params);
        return res.parse(GetCouponsResponse.class);
    }

    public GetCouponsResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public GetCouponByCodeResponse getByCode(String storeId, String code) throws Exception {
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/coupons/" + code);
        return res.parse(GetCouponByCodeResponse.class);
    }

    public GetCouponByIdResponse getById(String storeId, String couponId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().get("/stores/" + storeId + "/coupons/uuid/" + couponId);
        return res.parse(GetCouponByIdResponse.class);
    }

    public CreateCouponResponse create(String storeId, CreateCouponRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().post("/stores/" + storeId + "/coupons", input);
        return res.parse(CreateCouponResponse.class);
    }

    public UpdateCouponResponse update(String storeId, String couponId, UpdateCouponRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/coupons/" + couponId, input);
        return res.parse(UpdateCouponResponse.class);
    }

    public DeleteCouponResponse delete(String storeId, String couponId) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/stores/" + storeId + "/coupons/" + couponId);
        return res.parse(DeleteCouponResponse.class);
    }

    public ReorderCouponsResponse reorder(String storeId, List<String> couponIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("couponIds", couponIds);
        HttpResponse res = core.getHttp().put("/stores/" + storeId + "/coupons/reorder", body);
        return res.parse(ReorderCouponsResponse.class);
    }
}
