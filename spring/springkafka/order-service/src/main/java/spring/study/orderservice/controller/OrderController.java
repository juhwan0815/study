package spring.study.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.orderservice.model.OrderResponse;
import spring.study.orderservice.model.OrderSaveRequest;
import spring.study.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders/products/{productId}")
    public ResponseEntity saveOrder(@PathVariable Long productId, @RequestBody OrderSaveRequest request){
        return ResponseEntity.ok(orderService.saveOrder(productId, request));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> findOrders(){
        return ResponseEntity.ok(orderService.findOrders());
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity cancelOrder(@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }
}
