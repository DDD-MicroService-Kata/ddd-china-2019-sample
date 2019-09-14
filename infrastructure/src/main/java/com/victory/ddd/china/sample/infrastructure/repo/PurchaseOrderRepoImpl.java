package com.victory.ddd.china.sample.infrastructure.repo;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import lombok.val;

import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
public class PurchaseOrderRepoImpl implements PurchaseOrderRepo {
    @Override
    public List<PurchaseOrder> findAll() {
        val purchaseOrder = new PurchaseOrder("purchase-order");
        return Collections.singletonList(purchaseOrder);
    }
}
