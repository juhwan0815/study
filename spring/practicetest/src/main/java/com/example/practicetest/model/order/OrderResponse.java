package com.example.practicetest.model.order;

import com.example.practicetest.domain.Order;
import com.example.practicetest.domain.OrderStatus;
import com.example.practicetest.domain.Product;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class OrderResponse {

    private int count;

    private int totalPrice;

    private OrderStatus status;

    private Long productId;

    public OrderResponse(Order order) {
        this.count = order.getCount();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
        this.productId = order.getProduct().getId();
    }
}
