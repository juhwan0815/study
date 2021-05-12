package com.example.practicetest.service;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.Order;
import com.example.practicetest.domain.Product;
import com.example.practicetest.exception.MemberException;
import com.example.practicetest.exception.OrderException;
import com.example.practicetest.exception.ProductException;
import com.example.practicetest.model.order.OrderSaveRequest;
import com.example.practicetest.repository.MemberRepository;
import com.example.practicetest.repository.OrderRepository;
import com.example.practicetest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService{

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order saveOrder(Long memberId, OrderSaveRequest orderSaveRequest) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException("존재하지 않는 회원입니다."));

        Product findProduct = productRepository.findById(orderSaveRequest.getProductId())
                .orElseThrow(() -> new ProductException("존재하지 않는 상품입니다."));

        Order order = Order.createOrder(orderSaveRequest.getCount(),
                findMember, findProduct);

        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    @Transactional
    public Order updateOrder(Long orderId) {
        Order findOrder = orderRepository.findWithProductById(orderId)
                .orElseThrow(() -> new OrderException("존재하지 않는 주문입니다."));

        findOrder.cancel();
        return findOrder;
    }
}
