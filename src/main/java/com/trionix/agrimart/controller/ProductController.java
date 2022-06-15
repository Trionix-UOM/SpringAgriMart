package com.trionix.agrimart.controller;

import com.trionix.agrimart.dto.NewProductDto;
import com.trionix.agrimart.entity.Product;
import com.trionix.agrimart.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/products")

    public ResponseEntity<Product> addNewProduct(@RequestBody Product NewOrderDto) {
        Product product = new Product();
        product.setProductId(NewOrderDto.getProductId());
        product.setProductTitle(NewOrderDto.getProductTitle());
        product.setCategory(NewOrderDto.getCategory());
        product.setDescription(NewOrderDto.getDescription());
        product.setQuantity(NewOrderDto.getQuantity());
        product.setPrice(NewOrderDto.getPrice());

        return ResponseEntity.status(201).body(this.productRepository.save(product));
    }
      @CrossOrigin(origins = "http://localhost:3000")

        @GetMapping("/getproducts")
        public List<Product> getAllProducts () {
        return productRepository.findAll();
        }

        @GetMapping("/products/{id}")
        public String getOneProduct (@PathVariable String id){
            System.out.println(id);
            return "getOneProduct";
        }
        @DeleteMapping("/products/{id}")
        public String deleteProduct (@PathVariable String id){
            System.out.println(id);
            return "deleteProduct";
        }
        @PutMapping("/products/{id}")
        public String updateProduct (@RequestBody NewProductDto body, @PathVariable String id){
            System.out.println(body);
            return "updateProduct";
        }

    }

