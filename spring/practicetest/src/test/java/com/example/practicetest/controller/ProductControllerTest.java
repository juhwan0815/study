package com.example.practicetest.controller;

import com.example.practicetest.domain.Product;
import com.example.practicetest.model.product.ProductSaveRequest;
import com.example.practicetest.model.product.ProductUpdateRequest;
import com.example.practicetest.service.MemberService;
import com.example.practicetest.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    @DisplayName("상품 등록")
    void saveProduct() throws Exception {

        Product product = Product.createProduct("라면", 100, 500);

        ProductSaveRequest productSaveRequest = new ProductSaveRequest();
        productSaveRequest.setPrice(500);
        productSaveRequest.setStockQuantity(100);
        productSaveRequest.setName("라면");

        String body = objectMapper.writeValueAsString(productSaveRequest);

        given(productService.saveProduct(any()))
                .willReturn(product);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated());

        then(productService).should().saveProduct(any());
    }

    @Test
    @DisplayName("상품 수정")
    void updateProduct() throws Exception {

        Product product = Product.createProduct("라면", 200, 1000);

        ProductUpdateRequest updateRequest = new ProductUpdateRequest();
        updateRequest.setStockQuantity(200);
        updateRequest.setPrice(1000);

        String body = objectMapper.writeValueAsString(updateRequest);

        given(productService.updateProduct(any(), any()))
                .willReturn(product);

        mockMvc.perform(patch("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        then(productService).should().updateProduct(any(), any());
    }

    @Test
    @DisplayName("상품 ID 조회")
    void findById() throws Exception {
        Product product = Product.createProduct("라면", 200, 1000);

        given(productService.findProductById(any()))
                .willReturn(product);

        mockMvc.perform(get("/products/1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("라면"))
                .andExpect(jsonPath("$.stockQuantity").value(200))
                .andExpect(jsonPath("$.price").value(1000));

        then(productService).should().findProductById(any());
    }

    @Test
    @DisplayName("상품 리스트 조회")
    void findAll() throws Exception {
        Product product1 = Product.createProduct("라면", 200, 1000);
        Product product2 = Product.createProduct("계란", 200, 100);

        given(productService.findProducts())
                .willReturn(Arrays.asList(product1, product2));

        mockMvc.perform(get("/products")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("라면"))
                .andExpect(jsonPath("$.[1].name").value("계란"));

        then(productService).should().findProducts();
    }


}