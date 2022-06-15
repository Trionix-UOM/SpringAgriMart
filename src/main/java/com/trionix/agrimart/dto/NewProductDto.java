package com.trionix.agrimart.dto;

import lombok.Data;

@Data
public class NewProductDto {
    private Long productId;
    private String productTitle;
    private String category;
    private String description;
    private int quantity;
    private double price;

    public NewProductDto() {
    }

    public NewProductDto(Long productId, String productTitle, String category, String description, int quantity, double price) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

