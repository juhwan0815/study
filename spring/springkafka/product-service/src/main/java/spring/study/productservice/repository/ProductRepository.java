package spring.study.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.productservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
