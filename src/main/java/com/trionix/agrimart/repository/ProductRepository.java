package com.trionix.agrimart.repository;

import com.trionix.agrimart.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product,String> {




}
