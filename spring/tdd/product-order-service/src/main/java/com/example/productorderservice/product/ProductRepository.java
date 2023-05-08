package com.example.productorderservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
