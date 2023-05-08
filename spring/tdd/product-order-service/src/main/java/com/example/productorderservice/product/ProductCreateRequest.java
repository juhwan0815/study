package com.example.productorderservice.product;

import org.springframework.util.Assert;

public record ProductCreateRequest(String name, int price, DiscountPolicy discountPolicy) {
    public ProductCreateRequest {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
