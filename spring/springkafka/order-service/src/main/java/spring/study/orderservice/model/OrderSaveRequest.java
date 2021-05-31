package spring.study.orderservice.model;

import lombok.Data;

@Data
public class OrderSaveRequest {

    private Integer count;

    private Integer price;
}
