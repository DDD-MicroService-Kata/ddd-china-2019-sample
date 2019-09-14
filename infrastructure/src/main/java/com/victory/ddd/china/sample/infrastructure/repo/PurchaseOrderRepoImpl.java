package com.victory.ddd.china.sample.infrastructure.repo;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import com.victory.ddd.china.sample.infrastructure.dao.PurchaseOrderDao;
import lombok.NonNull;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class PurchaseOrderRepoImpl implements PurchaseOrderRepo {

    private PurchaseOrderDao purchaseOrderDao;

    @Inject
    public PurchaseOrderRepoImpl(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }

    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderDao.getAll();
    }

    @Override
    public Optional<PurchaseOrder> findById(@NonNull Integer orderId) {
        return purchaseOrderDao.getById(orderId);
    }

    @Override
    public void save(@NonNull PurchaseOrder order) {
        purchaseOrderDao.save(order);
    }

}
