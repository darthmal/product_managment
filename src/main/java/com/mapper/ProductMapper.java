package com.mapper;

import com.dto.ProductRequestDto;
import com.dto.ProductResponseDto;
import com.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract ProductResponseDto toDto(Product product);

    public abstract List<ProductResponseDto> toDtoList(List<Product> entities);

    @Mapping(target = "createdAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    public abstract Product toEntity(ProductRequestDto productDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "name", expression = ("java(source.getName() != null && !source.getName().isEmpty()  ? source.getName() : target.getName())"))
    @Mapping(target = "price", expression = ("java(source.getPrice() != null && !source.getPrice().equals(0)  ? source.getPrice() : target.getPrice())"))
    @Mapping(target = "stockQuantity", expression = ("java(source.getStockQuantity() != null && !source.getStockQuantity().equals(0)  ? source.getStockQuantity() : target.getStockQuantity())"))
    public abstract Product update(Product source, @MappingTarget Product target);
}
