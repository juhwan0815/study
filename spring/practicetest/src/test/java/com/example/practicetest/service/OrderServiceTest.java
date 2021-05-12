package com.example.practicetest.service;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.Order;
import com.example.practicetest.domain.OrderStatus;
import com.example.practicetest.domain.Product;
import com.example.practicetest.model.order.OrderSaveRequest;
import com.example.practicetest.repository.MemberRepository;
import com.example.practicetest.repository.OrderRepository;
import com.example.practicetest.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문 저장")
    void saveOrder() {
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Product product = Product.createProduct("라면", 100, 1000);
        Order order = new Order(1L, 5, 5 * product.getPrice(), OrderStatus.ORDER, member, product);

        OrderSaveRequest orderSaveRequest = new OrderSaveRequest();
        orderSaveRequest.setCount(5);
        orderSaveRequest.setProductId(1L);

        given(memberRepository.findById(any()))
                .willReturn(Optional.of(member));
        given(productRepository.findById(any()))
                .willReturn(Optional.of(product));
        given(orderRepository.save(any()))
                .willReturn(order);

        Order savedOrder = orderService.saveOrder(1L, orderSaveRequest);

        then(memberRepository).should().findById(any());
        then(productRepository).should().findById(any());
        then(orderRepository).should().save(any());
        assertAll(
                () -> assertThat(savedOrder.getCount()).isEqualTo(orderSaveRequest.getCount()),
                () -> assertThat(savedOrder.getTotalPrice()).isEqualTo(orderSaveRequest.getCount() * product.getPrice()),
                () -> assertThat(savedOrder.getMember()).isEqualTo(member),
                () -> assertThat(savedOrder.getProduct()).isEqualTo(product),
                () -> assertThat(product.getStockQuantity()).isEqualTo(95)
        );
    }

    @Test
    @DisplayName("주문 취소")
    void cancelOrder(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Product product = Product.createProduct("라면", 100, 1000);
        Order order = Order.createOrder(5, member, product);

        given(orderRepository.findWithProductById(any()))
                .willReturn(Optional.of(order));

        Order canceledOrder = orderService.updateOrder(1L);

        then(orderRepository).should().findWithProductById(any());
        assertAll(
                ()-> assertThat(canceledOrder.getStatus()).isEqualTo(OrderStatus.CANCEL),
                ()-> assertThat(canceledOrder.getProduct().getStockQuantity()).isEqualTo(100)
        );
    }

}