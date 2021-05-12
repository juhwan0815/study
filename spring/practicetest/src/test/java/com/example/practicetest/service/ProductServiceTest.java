package com.example.practicetest.service;

import com.example.practicetest.domain.Product;
import com.example.practicetest.domain.ProductStatus;
import com.example.practicetest.model.member.MemberResponse;
import com.example.practicetest.model.product.ProductSaveRequest;
import com.example.practicetest.model.product.ProductUpdateRequest;
import com.example.practicetest.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품 저장")
    void saveProduct() {
        Product product = Product.createProduct("라면", 100, 500);

        ProductSaveRequest productSaveRequest = new ProductSaveRequest();
        productSaveRequest.setName("라면");
        productSaveRequest.setStockQuantity(100);
        productSaveRequest.setPrice(500);

        given(productRepository.save(any()))
                .willReturn(product);

        Product savedProduct = productService.saveProduct(productSaveRequest);

        then(productRepository).should().save(any());
        assertAll(
                () -> assertThat(savedProduct.getName()).isEqualTo(productSaveRequest.getName()),
                () -> assertThat(savedProduct.getStockQuantity()).isEqualTo(productSaveRequest.getStockQuantity()),
                () -> assertThat(savedProduct.getPrice()).isEqualTo(productSaveRequest.getPrice()),
                () -> assertThat(savedProduct.getStatus()).isEqualTo(ProductStatus.ACTIVE)
        );
    }

    @Test
    @DisplayName("상품 업데이트")
    void updateProduct() {
        Product product = Product.createProduct("라면", 100, 500);

        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setPrice(1000);
        productUpdateRequest.setStockQuantity(200);

        given(productRepository.findById(any()))
                .willReturn(Optional.of(product));

        Product updateProduct = productService.updateProduct(1L, productUpdateRequest);

        assertAll(
                () -> assertThat(updateProduct.getPrice()).isEqualTo(productUpdateRequest.getPrice()),
                () -> assertThat(updateProduct.getStockQuantity()).isEqualTo(productUpdateRequest.getStockQuantity())
        );

        then(productRepository).should().findById(any());
    }

    @Test
    @DisplayName("상품 삭제")
    void deleteProduct() {
        Product product = Product.createProduct("라면", 100, 500);

        given(productRepository.findById(any()))
                .willReturn(Optional.of(product));

        productService.deleteProduct(1L);

        assertThat(product.getStatus()).isEqualTo(ProductStatus.DELETE);
        then(productRepository).should().findById(any());
    }

    @Test
    @DisplayName("상품ID 조회")
    void findById() {
        Product product = Product.createProduct("라면", 100, 500);

        given(productRepository.findById(any()))
                .willReturn(Optional.of(product));

        Product findProduct = productService.findProductById(1L);

        assertAll(
                () -> assertThat(findProduct.getName()).isEqualTo(findProduct.getName()),
                () -> assertThat(findProduct.getPrice()).isEqualTo(findProduct.getPrice()),
                () -> assertThat(findProduct.getStockQuantity()).isEqualTo(findProduct.getStockQuantity())
        );
    }

    @Test
    @DisplayName("상품 리스트 조회")
    void findProductList(){
        Product product1 = Product.createProduct("라면", 100, 500);
        Product product2 = Product.createProduct("계란", 100, 100);

        given(productRepository.findAll())
                .willReturn(Arrays.asList(product1,product2));

        List<Product> productList = productService.findProducts();

        assertThat(productList.size()).isEqualTo(2);
        then(productRepository).should().findAll();
    }

}