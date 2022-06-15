package com.trionix.agrimart.dto;

import lombok.Data;

@Data
public class NewCustomerDto {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String shippingAddress;

}
