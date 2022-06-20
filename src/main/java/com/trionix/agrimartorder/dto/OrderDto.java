package com.trionix.agrimartorder.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String productID;
    private Integer sellerId;
    private Integer shippingAddress;
}
