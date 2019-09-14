package com.victory.ddd.china.sample.application.dto;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString(includeFieldNames=true)
@Data
@Builder
public class PurchaseOrderSummaryDto {
    private String code;

    public static PurchaseOrderSummaryDto from(PurchaseOrder purchaseOrder) {
        return PurchaseOrderSummaryDto.builder().
                code(purchaseOrder.getCode()).
                build();
    }
}
