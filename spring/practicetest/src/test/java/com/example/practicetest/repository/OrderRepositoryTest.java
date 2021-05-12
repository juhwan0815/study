package com.example.practicetest.repository;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.Order;
import com.example.practicetest.domain.Product;
import com.example.practicetest.model.member.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("주문 생성")
    void findOrder(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Member savedMember = memberRepository.save(member);

        Product product = Product.createProduct("라면", 100, 500);
        productRepository.save(product);

        Order order = Order.createOrder(5,member, product);
        Order savedOrder = orderRepository.save(order);

        Order findOrder = orderRepository.findWithProductById(savedOrder.getId()).get();
        assertThat(findOrder.getId()).isNotNull();
        assertThat(findOrder.getProduct()).isEqualTo(product);
        assertThat(findOrder.getMember()).isEqualTo(member);
    }

}