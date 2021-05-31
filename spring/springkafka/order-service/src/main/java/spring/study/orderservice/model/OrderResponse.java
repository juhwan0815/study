package spring.study.orderservice.model;

import lombok.Data;
import spring.study.orderservice.domain.Order;
import spring.study.orderservice.domain.OrderStatus;

import java.time.LocalDateTime;

@Data
public class OrderResponse {

    private Long id;

    private Integer totalPrice;

    private Integer count;

    private Long productId;

    private OrderStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static OrderResponse from(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.id = order.getId();
        orderResponse.totalPrice = order.getTotalPrice();
        orderResponse.count = order.getCount();
        orderResponse.productId = order.getProductId();
        orderResponse.status = order.getStatus();
        orderResponse.createdAt = order.getCreatedAt();
        orderResponse.updatedAt = order.getUpdatedAt();
        return orderResponse;
    }
}
