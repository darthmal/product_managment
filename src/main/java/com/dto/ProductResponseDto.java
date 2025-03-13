package com.dto;

import com.domain.project.common.basestructure.dto.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private Integer lowStockThreshold = 5;
}
