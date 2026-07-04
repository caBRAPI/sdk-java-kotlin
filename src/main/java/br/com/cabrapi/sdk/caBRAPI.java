package br.com.cabrapi.sdk;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.module.category.CategoriesModule;
import br.com.cabrapi.sdk.module.coupon.CouponsModule;
import br.com.cabrapi.sdk.module.page.PagesModule;
import br.com.cabrapi.sdk.module.payment.PaymentsModule;
import br.com.cabrapi.sdk.module.product.ProductsModule;
import br.com.cabrapi.sdk.module.store.StoresModule;
import br.com.cabrapi.sdk.module.webhook.WebhooksModule;

public class caBRAPI {

    private final CoreClient core;
    private final ProductsModule products;
    private final StoresModule stores;
    private final WebhooksModule webhooks;
    private final CategoriesModule categories;
    private final CouponsModule coupons;
    private final PaymentsModule payments;
    private final PagesModule pages;

    public caBRAPI(CoreClient.Options options) {
        this.core = new CoreClient(options);
        this.products = new ProductsModule(core);
        this.stores = new StoresModule(core);
        this.webhooks = new WebhooksModule(core);
        this.categories = new CategoriesModule(core);
        this.coupons = new CouponsModule(core);
        this.payments = new PaymentsModule(core);
        this.pages = new PagesModule(core);
    }

    public ProductsModule products() {
        return products;
    }

    public StoresModule stores() {
        return stores;
    }

    public WebhooksModule webhooks() {
        return webhooks;
    }

    public CategoriesModule categories() {
        return categories;
    }

    public CouponsModule coupons() {
        return coupons;
    }

    public PaymentsModule payments() {
        return payments;
    }

    public PagesModule pages() {
        return pages;
    }
}
