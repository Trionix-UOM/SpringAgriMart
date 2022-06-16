package com.example.payment.controller;

import com.example.payment.dto.PaymentDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @PostMapping("/customer")
    public String CheckPayment(@RequestBody PaymentDto body)
    {
        System.out.println(body);
        return "Customer";
    }

    @GetMapping("/customer")
    public String getPayment()
    {

        return "Get All Payments";
    }

    @GetMapping("/customer/{id}")
    public String getOnePayment(@PathVariable String id)
    {
        System.out.println(id);
        return "Get One Payment";
    }

    @DeleteMapping("/customer/{id}")
    public String deletePayment(@PathVariable String id)
    {
        System.out.println(id);
        return "Delete Payment";
    }

    @PutMapping("/customer/{id}")
    public String updatePayment(@RequestBody PaymentDto body, @PathVariable String id)
    {
        System.out.println(body);
        return "Update Payment";
    }
}
