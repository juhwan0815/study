package com.example.practicetest.controller;

import com.example.practicetest.model.order.OrderSaveRequest;
import com.example.practicetest.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/members/{memberId}/orders")
    public ResponseEntity saveOrder(@PathVariable Long memberId,
                                    @RequestBody OrderSaveRequest orderSaveRequest){
        orderService.saveOrder(memberId,orderSaveRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/orders/{orderId}")
    public ResponseEntity updateOrder(@PathVariable Long orderId){
        orderService.updateOrder(orderId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
