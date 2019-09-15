package com.victory.ddd.china.sample.infrastructure.dao;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseOrderInMemoryDao implements PurchaseOrderDao {

    private ArrayList<PurchaseOderPO> purchaseOrders;
    private Integer idSequence = 0;

    public PurchaseOrderInMemoryDao() {
        initMemoryCollection();
    }

    private void initMemoryCollection() {

        purchaseOrders = new ArrayList<>();
    }

    private Integer getIncreasedId() {
        idSequence = idSequence + 1;
        return idSequence;
    }

    @Override
    public List<PurchaseOderPO> getAll() {
        return ImmutableList.copyOf(purchaseOrders);
    }

    @Override
    public Optional<PurchaseOderPO> getById(@NonNull Integer orderId) {
        return purchaseOrders.stream().
                filter(purchaseOrder ->
                        orderId.equals(purchaseOrder.getId())).
                findFirst();
    }

    @Override
    public void insert(@NonNull PurchaseOderPO order) {
        order.setId(getIncreasedId());
        purchaseOrders.add(order);
    }

    public void clear() {
        this.purchaseOrders.clear();
    }
}
