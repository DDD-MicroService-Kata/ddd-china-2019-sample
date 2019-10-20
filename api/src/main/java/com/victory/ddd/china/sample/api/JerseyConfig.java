package com.victory.ddd.china.sample.api;

import com.victory.ddd.china.sample.api.controller.PurchaseOrderResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.victory.ddd.china.sample.api");
    }
}
