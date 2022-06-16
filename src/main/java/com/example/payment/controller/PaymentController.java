package com.example.payment.controller;
import com.example.payment.dto.PaymentDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @PostMapping("/payment")
    public String CheckPayment()
    {
//        System.out.println(body);
        return "CheckPayment";
    }

}
