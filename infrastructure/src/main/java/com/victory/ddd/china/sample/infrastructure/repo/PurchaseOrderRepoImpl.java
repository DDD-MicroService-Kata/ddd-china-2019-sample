package com.victory.ddd.china.sample.infrastructure.repo;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import com.victory.ddd.china.sample.infrastructure.dao.PurchaseOrderPO;
import com.victory.ddd.china.sample.infrastructure.dao.PurchaseOrderDao;
import lombok.NonNull;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class PurchaseOrderRepoImpl implements PurchaseOrderRepo {

    private PurchaseOrderDao purchaseOrderDao;

    @Inject
    public PurchaseOrderRepoImpl(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }

    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderDao.getAll().stream().
                map(PurchaseOrderPO::to).
                collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseOrder> findById(@NonNull Integer orderId) {
        val po = purchaseOrderDao.getById(orderId);
        return po.map(PurchaseOrderPO::to);
    }

    @Override
    public void save(@NonNull PurchaseOrder order) {
        val from = PurchaseOrderPO.from(order);
        purchaseOrderDao.insert(from);
        order.setId(from.getId());
    }

}
