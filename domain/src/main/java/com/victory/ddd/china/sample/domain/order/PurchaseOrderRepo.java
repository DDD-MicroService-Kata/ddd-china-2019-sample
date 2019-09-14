package com.victory.ddd.china.sample.domain.order;

import java.util.List;

public interface PurchaseOrderRepo {
    List<PurchaseOrder> findAll();
}
