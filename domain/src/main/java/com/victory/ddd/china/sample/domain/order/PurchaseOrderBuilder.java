package com.victory.ddd.china.sample.domain.order;

import lombok.NonNull;

public class PurchaseOrderBuilder {
    private Integer id;
    private String code;

    public PurchaseOrderBuilder id(@NonNull Integer id) {
        this.id = id;
        return this;
    }

    public PurchaseOrderBuilder code(@NonNull String code) {
        this.code = code;
        return this;
    }

    public PurchaseOrder build() {
        return new PurchaseOrder(id, code);
    }

    public static PurchaseOrderBuilder getInstance() {
        return new PurchaseOrderBuilder();
    }
}
