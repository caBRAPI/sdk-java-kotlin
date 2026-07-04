package br.com.cabrapi.sdk.module.page;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.page.*;

public class PagesModule {

    private final CoreClient core;

    public PagesModule(CoreClient core) {
        this.core = core;
    }

    public HttpResponse get(String domain) throws Exception {
        return core.getHttp().get("/pages/" + domain);
    }

    public HttpResponse upsert(UpsertPageRequest input) throws Exception {
        core.assertPrivate();
        return core.getHttp().put("/pages/" + input.getDomain(), input);
    }

    public HttpResponse delete(String domain) throws Exception {
        core.assertPrivate();
        return core.getHttp().delete("/pages/" + domain);
    }
}
