package com.example.practicetest.model.order;

import lombok.Data;

@Data
public class OrderSaveRequest {

    private Long productId;

    private Integer count;
}
