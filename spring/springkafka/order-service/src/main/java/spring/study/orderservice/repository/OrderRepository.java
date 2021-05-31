package spring.study.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.orderservice.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
