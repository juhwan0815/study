package com.example.practicetest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int stockQuantity;

    private int price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public static Product createProduct(String name, int stockQuantity, int price){
        Product product = new Product();
        product.name = name;
        product.stockQuantity = stockQuantity;
        product.price = price;
        product.status = ProductStatus.ACTIVE;
        return product;
    }

    public void updateProduct(int price, int stockQuantity) {
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void changeStatus() {
        this.status = ProductStatus.DELETE;
    }

    public void minusStockQuantity(int changeCount){
        this.stockQuantity -= changeCount;
    }

    public void plusStockQuantity(int changeCount) {
        this.stockQuantity += changeCount;
    }
}
