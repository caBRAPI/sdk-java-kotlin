package br.com.cabrapi.sdk.module.page;

import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.client.HttpClient.HttpResponse;
import br.com.cabrapi.sdk.model.page.*;

public class PagesModule {

    private final CoreClient core;

    public PagesModule(CoreClient core) {
        this.core = core;
    }

    public Page get(String domain) throws Exception {
        HttpResponse res = core.getHttp().get("/pages/" + domain);
        GetPageResponse parsed = res.parse(GetPageResponse.class);
        if (parsed == null || parsed.getData() == null) {
            throw new RuntimeException("Page not found: " + domain);
        }
        return parsed.getData();
    }

    public UpsertPageResponse upsert(UpsertPageRequest input) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().put("/pages/" + input.getDomain(), input);
        return res.parse(UpsertPageResponse.class);
    }

    public DeletePageResponse delete(String domain) throws Exception {
        core.assertPrivate();
        HttpResponse res = core.getHttp().delete("/pages/" + domain);
        return res.parse(DeletePageResponse.class);
    }
}
