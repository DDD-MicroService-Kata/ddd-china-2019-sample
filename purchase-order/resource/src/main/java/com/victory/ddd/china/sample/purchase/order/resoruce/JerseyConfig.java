package com.victory.ddd.china.sample.purchase.order.resoruce;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig()
    {
        register(PurchaseOrderResource.class);
    }
}
