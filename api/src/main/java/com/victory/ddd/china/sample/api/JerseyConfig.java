package com.victory.ddd.china.sample.api;

import com.victory.ddd.china.sample.api.controller.PurchaseOrderResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig()
    {
        register(PurchaseOrderResource.class);
    }
}
