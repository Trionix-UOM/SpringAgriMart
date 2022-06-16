package com.trionix.agrimartorder.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String description;
    private Integer price;
    private Integer Quantity;
}
