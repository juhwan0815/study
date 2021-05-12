package com.example.practicetest.controller;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.Order;
import com.example.practicetest.domain.Product;
import com.example.practicetest.model.order.OrderSaveRequest;
import com.example.practicetest.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("주문 저장")
    void saveOrder() throws Exception {
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Product product = Product.createProduct("라면", 100, 1000);
        Order order = Order.createOrder(5, member, product);

        OrderSaveRequest orderSaveRequest = new OrderSaveRequest();
        orderSaveRequest.setProductId(1L);
        orderSaveRequest.setCount(5);

        given(orderService.saveOrder(any(), any(OrderSaveRequest.class)))
                .willReturn(order);

        String body = objectMapper.writeValueAsString(orderSaveRequest);

        mockMvc.perform(post("/members/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated());

        then(orderService).should().saveOrder(any(),any());
    }


}