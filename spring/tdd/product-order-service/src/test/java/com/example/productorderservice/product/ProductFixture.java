package com.example.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductFixture {

    public static ProductCreateRequest 상품등록요청_생성() {
        String name = "상품명";
        int price = 1000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        ProductCreateRequest request = new ProductCreateRequest(name, price, discountPolicy);
        return request;
    }

    public static ExtractableResponse<Response> 상품등록요청(ProductCreateRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }
}


