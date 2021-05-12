package com.example.practicetest.repository;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select" +
            " o from Order o join fetch o.product where o.id=:orderId")
    Optional<Order> findWithProductById(@Param("orderId") Long orderId);

    List<Order> findByMember(Member member);
}
