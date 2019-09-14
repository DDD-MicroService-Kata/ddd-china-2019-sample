package com.victory.ddd.china.sample.domain.order;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderRepo {
    List<PurchaseOrder> findAll();

    Optional<PurchaseOrder> findById(@NonNull Integer orderId);

    void save(@NonNull PurchaseOrder order);
}
