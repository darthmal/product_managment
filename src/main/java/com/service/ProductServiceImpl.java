package com.service;

import com.common.utils.EntityNotFoundException;
import com.dto.ProductRequestDto;
import com.mapper.ProductMapper;
import com.model.Product;
import com.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    @Transactional
    public Product createProduct(ProductRequestDto productDTO) {
        return productRepository.save(productMapper.toEntity(productDTO));
    }

    @Transactional
    public Product updateProduct(Long id, ProductRequestDto productDTO) {
        Product target = getProduct(id);
        Product source = productMapper.toEntity(productDTO);
        return productRepository.save(productMapper.update(source, target));
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.delete(getProduct(id));
    }

    @Transactional(readOnly = true)
    public List<Product> getLowStockProducts() {
        return new ArrayList<>(productRepository.findByStockQuantityLessThanEqual(5));
    }
}
