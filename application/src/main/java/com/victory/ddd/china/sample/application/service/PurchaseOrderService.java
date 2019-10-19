package com.victory.ddd.china.sample.application.service;

import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceInfoDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceResultDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderSummaryDto;
import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import lombok.NonNull;
import lombok.val;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class PurchaseOrderService {

    private PurchaseOrderRepo purchaseOrderRepo;

    @Inject
    public PurchaseOrderService(PurchaseOrderRepo purchaseOrderRepo, PlatformTransactionManager transactionManager) {
        this.purchaseOrderRepo = purchaseOrderRepo;
    }

    public List<PurchaseOrderSummaryDto> getPurchaseOrdersSummary() {
        final List<PurchaseOrder> purchaseOrders = purchaseOrderRepo.findAll();
        return purchaseOrders.stream().map(PurchaseOrderSummaryDto::from).
                collect(Collectors.toList());
    }

    @Transactional
    public PurchaseOrderPlaceResultDto placeOrder(@NonNull PurchaseOrderPlaceInfoDto createRequest) {
        PurchaseOrder order = new PurchaseOrder(createRequest.getCode());
        order.setId(1);
        purchaseOrderRepo.save(order);
        return PurchaseOrderPlaceResultDto.from(order);
    }
}
