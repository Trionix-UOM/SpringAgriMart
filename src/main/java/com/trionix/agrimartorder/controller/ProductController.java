package com.trionix.agrimartorder.controller;
import com.trionix.agrimartorder.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @PostMapping("/products")
    public String ShowProduct(@RequestBody ProductDto body)
    {
        System.out.println(body);
        return "ShowProducts";

    }

    @GetMapping("/products")
    public String GetAllProducts()
    {
        return "GetAllProducts";

    }

//    public String GetAllProducts(@RequestBody ProductDto body,@PathVariable String id)
//    {
//        System.out.println(body);
//        return "Get All Products";
//
//    }


}
