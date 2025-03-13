package com.service;

import com.dto.ProductRequestDto;
import com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product createProduct(ProductRequestDto productDTO);

    Product updateProduct(Long id, ProductRequestDto productDTO);
    
    void deleteProduct(Long id);
    
    List<Product> getLowStockProducts();
}
