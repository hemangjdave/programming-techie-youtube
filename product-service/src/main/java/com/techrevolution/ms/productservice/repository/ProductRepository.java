package com.techrevolution.ms.productservice.repository;

import com.techrevolution.ms.productservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity , String> {
}
