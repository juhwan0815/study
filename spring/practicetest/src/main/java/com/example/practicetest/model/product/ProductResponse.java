package com.example.practicetest.model.product;

import com.example.practicetest.domain.Product;
import lombok.Data;

@Data
public class ProductResponse {

    private Long id;

    private String name;

    private Integer stockQuantity;

    private Integer price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.stockQuantity = product.getStockQuantity();
        this.price = product.getPrice()
        ;
    }
}
