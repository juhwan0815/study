package spring.study.productservice.model;

import lombok.Data;
import spring.study.productservice.domain.Product;

import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private Long id;

    private String name;

    private Integer stock;

    private Integer price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductResponse from(Product product){
        ProductResponse producerResponse = new ProductResponse();
        producerResponse.id = product.getId();
        producerResponse.name = product.getName();
        producerResponse.stock = product.getStock();
        producerResponse.price = product.getPrice();
        producerResponse.createdAt = product.getCreatedAt();
        producerResponse.updatedAt = product.getUpdatedAt();
        return producerResponse;
    }
}
