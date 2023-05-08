package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.productorderservice.product.ProductFixture.상품등록요청_생성;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void 상품등록() {
        ProductCreateRequest request = 상품등록요청_생성();
        productService.createProduct(request);
    }

}
