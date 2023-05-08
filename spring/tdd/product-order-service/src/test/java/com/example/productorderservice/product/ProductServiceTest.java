package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static com.example.productorderservice.product.ProductFixture.*;
import static com.example.productorderservice.product.ProductFixture.상품등록요청_생성;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void 상품등록() {
        ProductCreateRequest request = 상품등록요청_생성();
        productService.createProduct(request);
    }

    @Test
    void 상품조회() {
        // 상품등록
        productService.createProduct(상품등록요청_생성());
        Long productId = 1L;

        // 상품을 조회
        ProductResponse response = productService.findProduct(productId);

        // 상품의 응답을 검증
        assertThat(response).isNotNull();
    }

}
