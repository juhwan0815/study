package com.example.practicetest.model.product;

import lombok.Data;

@Data
public class ProductSaveRequest {

    private String name;

    private int stockQuantity;

    private int price;
}
