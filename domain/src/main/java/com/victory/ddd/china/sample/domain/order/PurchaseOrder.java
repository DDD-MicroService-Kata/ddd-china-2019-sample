package com.victory.ddd.china.sample.domain.order;

public class PurchaseOrder {
    private String code;
    private Integer id;

    public PurchaseOrder(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public PurchaseOrder(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
