package com.victory.ddd.china.sample.infrastructure.dao;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderDao {
    List<PurchaseOrder> getAll();

    Optional<PurchaseOrder> getById(@NonNull Integer orderId);

    void save(@NonNull PurchaseOrder order);
}
