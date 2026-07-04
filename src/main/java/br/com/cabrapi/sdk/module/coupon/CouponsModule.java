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

    public HttpResponse get(String storeId, GetCouponsRequest input) throws Exception {
        core.assertPrivate();
        Map<String, Object> params = new HashMap<>();
        if (input != null) {
            if (input.getPage() != null) params.put("page", input.getPage());
            if (input.getLimit() != null) params.put("limit", input.getLimit());
        }
        return core.getHttp().get("/stores/" + storeId + "/coupons", params.isEmpty() ? null : params);
    }

    public HttpResponse get(String storeId) throws Exception {
        return get(storeId, null);
    }

    public HttpResponse getByCode(String storeId, String code) throws Exception {
        return core.getHttp().get("/stores/" + storeId + "/coupons/" + code);
    }

    public HttpResponse getById(String storeId, String couponId) throws Exception {
        core.assertPrivate();
        return core.getHttp().get("/stores/" + storeId + "/coupons/uuid/" + couponId);
    }

    public HttpResponse create(String storeId, CreateCouponRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().post("/stores/" + storeId + "/coupons", input);
    }

    public HttpResponse update(String storeId, String couponId, UpdateCouponRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().put("/stores/" + storeId + "/coupons/" + couponId, input);
    }

    public HttpResponse delete(String storeId, String couponId) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/stores/" + storeId + "/coupons/" + couponId);
    }

    public HttpResponse reorder(String storeId, List<String> couponIds) throws Exception {
        core.assertPrivate();
        Map<String, Object> body = new HashMap<>();
        body.put("couponIds", couponIds);
        return core.getHttp().put("/stores/" + storeId + "/coupons/reorder", body);
    }
}
