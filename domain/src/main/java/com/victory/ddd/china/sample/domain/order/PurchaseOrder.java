package com.victory.ddd.china.sample.domain.order;

public class PurchaseOrder {
    private final String code;
    private Integer id;

    public PurchaseOrder(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idSequence) {
        this.id = idSequence;
    }
}
