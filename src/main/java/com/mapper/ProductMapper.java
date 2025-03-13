package com.mapper;

import com.dto.ProductDTO;
import com.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    
    Product toEntity(ProductDTO productDTO);
    
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProductDTO productDTO, @MappingTarget Product product);
}
