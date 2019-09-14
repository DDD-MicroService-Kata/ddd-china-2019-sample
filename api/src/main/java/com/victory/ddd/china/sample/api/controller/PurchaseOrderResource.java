package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceInfoDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceResultDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderSummaryDto;
import com.victory.ddd.china.sample.application.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    public List<PurchaseOrderSummaryDto> findAll() {
        return service.getPurchaseOrdersSummary();
    }

    @POST
    @Path("/")
    public PurchaseOrderPlaceResultDto placeOrder(PurchaseOrderPlaceInfoDto createRequest) {
        return service.placeOrder(createRequest);
    }
}

