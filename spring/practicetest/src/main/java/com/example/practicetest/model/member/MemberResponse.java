package com.example.practicetest.model.member;

import com.example.practicetest.domain.Member;
import com.example.practicetest.model.order.OrderResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MemberResponse {

    private Long id;

    private String email;

    private String name;

    private String phoneNumber;

    private List<OrderResponse> orderList;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phoneNumber = member.getPhoneNumber();
        this.orderList = member.getOrderList().stream()
                .map(order -> new OrderResponse(order))
                .collect(Collectors.toList());
    }
}
