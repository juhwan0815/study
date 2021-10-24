package com.study.jacoco.dto;

import com.study.jacoco.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private Long id;

    private String name;

    private Integer age;

    public static MemberResponse from(Member member){
        MemberResponse memberResponse = new MemberResponse();
        memberResponse.id = member.getId();
        memberResponse.name = member.getName();
        memberResponse.age = member.getAge();
        return memberResponse;
    }
}
