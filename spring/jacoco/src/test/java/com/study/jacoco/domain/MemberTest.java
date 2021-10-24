package com.study.jacoco.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    @Test
    @DisplayName("회원 생성 테스트")
    void createMember(){
        // given
        String name = "테스트 사용자";
        Integer age = 20;

        // when
        Member member = Member.createMember(name, age);

        // then
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getAge()).isEqualTo(age);
    }

    @Test
    @DisplayName("회원 수정 테스트")
    void update(){
        // given
        String updateName = "테스트 사용자1";
        Integer updateAge = 21;
        Member member = Member.createMember("테스트  사용자", 20);

        // when
        member.update(updateName,updateAge);

        // then
        assertThat(member.getName()).isEqualTo(updateName);
        assertThat(member.getAge()).isEqualTo(updateAge);
    }
}
