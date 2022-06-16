package com.trionix.agrimartorder.controller;
import com.trionix.agrimartorder.dto.NewShippingAddressDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewShippingAddressController {
    @PostMapping("/shipping")
    public String CreateShippingDetails(@RequestBody NewShippingAddressDto body)
    {
        System.out.println(body);
        return "CreateShippingDetails";
    }

    @GetMapping("/shipping")
    public String GetAllShippingAddress()
    {
        return "CreateShippingDetails";
    }

    @DeleteMapping("/shipping/{shippingId}")
    public String DeleteShippingAddress(@PathVariable String shippingId)
    {
        System.out.println(shippingId);
        return "DeleteShippingDetails";
    }

    @PutMapping("/shipping/{shippingId}")
    public String UpdateShippingAddress(@RequestBody NewShippingAddressDto body, @PathVariable String shippingId)
    {
        System.out.println(body);
        System.out.println(shippingId);
        return "UpdateShippingDetails";
    }
}
