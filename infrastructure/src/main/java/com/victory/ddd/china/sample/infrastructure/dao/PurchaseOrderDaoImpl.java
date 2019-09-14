package com.victory.ddd.china.sample.infrastructure.dao;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import lombok.NonNull;

import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
    @Override
    public List<PurchaseOrder> getAll() {
        return null;
    }

    @Override
    public Optional<PurchaseOrder> getById(@NonNull Integer orderId) {
        return Optional.empty();
    }

    @Override
    public void save(@NonNull PurchaseOrder order) {

    }
}
