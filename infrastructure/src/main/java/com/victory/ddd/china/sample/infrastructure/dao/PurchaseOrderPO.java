package com.victory.ddd.china.sample.infrastructure.dao;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Getter
@Builder
public class PurchaseOrderPO {
    private Integer id;
    private String code;

    public static PurchaseOrderPO from(@NonNull PurchaseOrder order) {
        return PurchaseOrderPO.builder()
                .id(order.getId())
                .code(order.getCode())
                .build();
    }

    public PurchaseOrder to() {
        return PurchaseOrderBuilder.
                getInstance().
                code(getCode()).
                id(getId()).
                build();
    }
}
