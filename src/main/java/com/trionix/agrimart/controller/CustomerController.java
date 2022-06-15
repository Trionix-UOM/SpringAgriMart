package com.trionix.agrimart.controller;


import com.trionix.agrimart.dto.NewCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @PostMapping("/customers")
    public String createCustomer(@RequestBody NewCustomerDto body){
        System.out.println(body);
        return "Post All Customers";
    }
    @GetMapping("/customers")
    public String getAllCustomer(){
        return "getAllCustomer";
    }

    @GetMapping("/customers/{id}")
    public String getOneCustomer(@PathVariable String id){
        System.out.println(id);
        return "getOneCustomer";
    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable String id){
        System.out.println(id);
        return "deleteCustomer";
    }
    @PutMapping("/customers/{id}")
    public String updateCustomer(@RequestBody NewCustomerDto body, @PathVariable String id){
        System.out.println(body);
        return "updateCustomer";
    }
}



