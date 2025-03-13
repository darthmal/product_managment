package com.model;

import com.domain.project.common.MandatoryField;
import com.domain.project.common.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MandatoryField
    private String name;

    @MandatoryField
    private BigDecimal price;

    @Column(name = "stock_quantity")
    @MandatoryField
    private Integer stockQuantity;

    @Column(name = "low_stock_threshold")
    private Integer lowStockThreshold = 5;

    public boolean isLowStock() {
        return stockQuantity <= lowStockThreshold;
    }
}
