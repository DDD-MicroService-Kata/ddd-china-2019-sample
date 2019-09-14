package com.victory.ddd.china.sample.domain.order;

public class PurchaseOrder {
    private final String code;

    public PurchaseOrder(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
