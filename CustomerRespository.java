package com.example.agrimart_4.repository;

import com.example.agrimart_4.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRespository extends MongoRepository<Customer,String>
 {
}
