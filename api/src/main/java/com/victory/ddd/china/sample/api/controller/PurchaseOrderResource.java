package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.dto.PurchaseOrderSummaryDto;
import com.victory.ddd.china.sample.application.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
@Path("/purchase-orders")
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseOrderResource {

    private PurchaseOrderService service;

    @Autowired
    public PurchaseOrderResource(PurchaseOrderService service) {
        this.service = service;
    }

    @GET
    @Path("/")
    public List<PurchaseOrderSummaryDto> demo() {
        return service.getPurchaseOrdersSummary();
    }

}

