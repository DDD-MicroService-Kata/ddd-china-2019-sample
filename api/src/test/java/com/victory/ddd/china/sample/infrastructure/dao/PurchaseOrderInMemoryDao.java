package com.victory.ddd.china.sample.infrastructure.dao;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import lombok.NonNull;
import lombok.val;
import org.springframework.context.annotation.Primary;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
@Primary
public class PurchaseOrderInMemoryDao implements PurchaseOrderDao {

    private ArrayList<PurchaseOrder> purchaseOrders;
    private Integer idSequence = 0;

    public PurchaseOrderInMemoryDao() {
        initMemoryCollection();
    }

    private void initMemoryCollection() {
        val purchaseOrder = new PurchaseOrder("purchase-order");
        purchaseOrder.setId(getIncreasedId());
        purchaseOrders = Lists.newArrayList(purchaseOrder);
    }

    private Integer getIncreasedId() {
        idSequence = idSequence + 1;
        return idSequence;
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return ImmutableList.copyOf(purchaseOrders);
    }

    @Override
    public Optional<PurchaseOrder> getById(@NonNull Integer orderId) {
        return purchaseOrders.stream().
                filter(purchaseOrder ->
                        orderId.equals(purchaseOrder.getId())).
                findFirst();
    }

    @Override
    public void save(@NonNull PurchaseOrder order) {
        order.setId(getIncreasedId());
        purchaseOrders.add(order);
    }

}
