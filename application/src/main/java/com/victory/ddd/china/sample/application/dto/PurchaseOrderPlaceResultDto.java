package com.victory.ddd.china.sample.application.dto;

import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

@Data
@NoArgsConstructor
@Setter
public class PurchaseOrderPlaceResultDto {
    private Integer id;

    public static PurchaseOrderPlaceResultDto from(PurchaseOrder order) {
        val dto = new PurchaseOrderPlaceResultDto();
        dto.setId(order.getId());
        return dto;
    }
}
