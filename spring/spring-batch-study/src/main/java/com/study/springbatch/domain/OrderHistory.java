package com.study.springbatch.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private String productIds;

    public OrderHistory(Order order, List<Product> products) {
        this.order = order;
        this.productIds = products.stream()
                .map(product -> String.valueOf(product.getId()))
                .collect(Collectors.joining(", "));
    }
}
