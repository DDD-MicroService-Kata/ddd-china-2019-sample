package com.victory.ddd.china.sample.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Data
@NoArgsConstructor
@Setter
public class PurchaseOrderPlaceInfoDto {
    private String code;
}
