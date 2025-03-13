package com.service;

import com.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    
    ProductDTO getProduct(Long id);
    
    ProductDTO createProduct(ProductDTO productDTO);
    
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    
    void deleteProduct(Long id);
    
    List<ProductDTO> getLowStockProducts();
}
