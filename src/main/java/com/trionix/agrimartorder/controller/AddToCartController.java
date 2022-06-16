package com.trionix.agrimartorder.controller;
import com.trionix.agrimartorder.dto.AddToCartDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddToCartController {
    @PostMapping("/receiveToCart")
    public String CreateCart(@RequestBody AddToCartDto body)
    {
        System.out.println(body);
        return "CreateCart";
    }

    @DeleteMapping("/receiveToCart/{cartId}")
    public String DeleteCart(@PathVariable AddToCartDto cartId)
    {
        System.out.println(cartId);
        return "DeleteCart";
    }

    @PutMapping("/receiveToCart/{cartId}")
    public String UpdateCart(@RequestBody AddToCartDto body,@PathVariable String cartId)
    {
        System.out.println(cartId);
        return "UpdateCart";
    }
}
