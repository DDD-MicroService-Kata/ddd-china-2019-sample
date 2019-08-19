package com.victory.ddd.china.sample.purchase.order.resoruce;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collections;
import java.util.List;

@Path("/purchase-orders")
public class PurchaseOrderResource {
    @GET
    @Path("/")
    @Produces("application/vnd.collection+json")
    public List<String> demo() {
        return Collections.singletonList("purchase-order");
    }
}
