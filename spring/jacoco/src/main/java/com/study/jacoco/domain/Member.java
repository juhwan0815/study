package com.study.jacoco.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Integer age;

    public static Member createMember(String name,Integer age){
        Member member = new Member();
        member.name = name;
        member.age = age;
        return member;
    }

    public void update(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
