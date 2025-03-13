package com.dto;

import com.common.MandatoryField;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    @MandatoryField
    private String name;

    @MandatoryField
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private BigDecimal price;

    @MandatoryField
    @Min(value = 0, message = "Stock quantity must be greater than or equal to 0")
    private Integer stockQuantity;

    private Integer lowStockThreshold = 5;
}
