package com.example.practicetest.repository;

import com.example.practicetest.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("상품 등록")
    void saveProduct(){
        Product product = Product.createProduct("라면", 100, 1000);
        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct.getId()).isNotNull();
    }

    @Test
    @DisplayName("특정 상품 조회")
    void findProduct(){
        Product product = Product.createProduct("라면", 100, 1000);
        Product savedProduct = productRepository.save(product);

        em.flush();
        em.clear();

        Product findProduct = productRepository.findById(savedProduct.getId()).get();
        assertThat(findProduct.getId()).isEqualTo(savedProduct.getId());
    }


}