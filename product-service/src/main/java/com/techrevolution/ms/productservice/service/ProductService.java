package com.techrevolution.ms.productservice.service;

import com.techrevolution.ms.productservice.dto.ProductRequest;
import com.techrevolution.ms.productservice.dto.ProductResponse;
import com.techrevolution.ms.productservice.entity.ProductEntity;
import com.techrevolution.ms.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = mapProduct(productRequest);
        productRepository.save(productEntity);
        return mapProductResponse(productEntity);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapProductResponse)
                .toList();
    }

    private ProductResponse mapProductResponse(ProductEntity productEntity) {
        return new ProductResponse(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }

    private ProductEntity mapProduct(ProductRequest productRequest) {
        return ProductEntity.create(
                null,
                productRequest.name(),
                productRequest.description(),
                productRequest.price()
        );
    }


}
