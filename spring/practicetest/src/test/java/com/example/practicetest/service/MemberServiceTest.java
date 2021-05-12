package com.example.practicetest.service;

import com.example.practicetest.domain.Member;
import com.example.practicetest.domain.MemberStatus;
import com.example.practicetest.exception.MemberException;
import com.example.practicetest.model.member.MemberSaveRequest;
import com.example.practicetest.model.member.MemberUpdateRequest;
import com.example.practicetest.repository.MemberRepository;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입")
    void saveMember(){
        // given
        Member member = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");
        MemberSaveRequest memberSaveRequest = new MemberSaveRequest();
        memberSaveRequest.setEmail("juwom0831@naver.com");
        memberSaveRequest.setName("황주환");
        memberSaveRequest.setPhoneNumber("010-2058-4660");

        given(memberRepository.findByEmail("juwom0831@naver.com"))
                .willReturn(Optional.empty());
        given(memberRepository.save(any()))
                .willReturn(member);

        // when
        memberService.saveMember(memberSaveRequest);

        then(memberRepository).should(times(1)).findByEmail(any());
        then(memberRepository).should(times(1)).save(any());
    }


    @Test
    @DisplayName("회원 가입 이메일 중복 체크")
    void checkSaveDuplicatedMember(){
        // given
        Member member = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");
        MemberSaveRequest memberSaveRequest = new MemberSaveRequest();
        memberSaveRequest.setEmail("juwom0831@naver.com");
        memberSaveRequest.setName("황주환");
        memberSaveRequest.setPhoneNumber("010-2058-4660");


        given(memberRepository.findByEmail("juwom0831@naver.com"))
                .willReturn(Optional.of(member));

        // when
        // then
        assertThrows(MemberException.class,()->memberService.saveMember(memberSaveRequest));
        then(memberRepository).should().findByEmail("juwom0831@naver.com");
    }

    @Test
    @DisplayName("회원 정보 수정")
    void updateMember(){
        // given
        Member member = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");
        MemberUpdateRequest memberUpdateRequest = new MemberUpdateRequest();
        memberUpdateRequest.setName("황주환");
        memberUpdateRequest.setPhoneNumber("010-2058-4660");

        given(memberRepository.findById(any()))
                .willReturn(Optional.of(member));

        // when
        Member updateMember = memberService.updateMember(1L,memberUpdateRequest);

        // then
        then(memberRepository).should(times(1)).findById(any());
        assertThat(updateMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(updateMember.getName()).isEqualTo(memberUpdateRequest.getName());
        assertThat(updateMember.getPhoneNumber()).isEqualTo(memberUpdateRequest.getPhoneNumber());
    }

    @Test
    @DisplayName("회원 탈퇴")
    void deleteMember(){
        Member member = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");

        given(memberRepository.findById(any()))
                .willReturn(Optional.of(member));

        memberService.deleteMember(1L);

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DELETED);
        then(memberRepository).should(times(1)).findById(any());
    }

    @Test
    @DisplayName("회원 ID로 조회")
    void findMemberById(){
        Member member = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");
        given(memberRepository.findWithOrderById(any()))
                .willReturn(Optional.of(member));

        Member findMember = memberService.findMemberById(1L);

        assertThat(findMember.getName()).isEqualTo("황주환");
        assertThat(findMember.getEmail()).isEqualTo("juwom0831@naver.com");
        assertThat(findMember.getPhoneNumber()).isEqualTo("010-2058-4660");
        then(memberRepository).should(times(1)).findWithOrderById(any());
    }

    @Test
    @DisplayName("회원 모두 조회")
    void findMembers(){
        Member member1 = Member.createMember("juwom0831@naver.com","황주환","010-2058-4660");
        Member member2 = Member.createMember("juwom0831@gmail.com","황주환","010-2058-4660");

        given(memberRepository.findAllWithOrder())
                .willReturn(Arrays.asList(member1,member2));

        List<Member> findMembers = memberService.findMembers();

        assertThat(findMembers.size()).isEqualTo(2);
        then(memberRepository).should(times(1)).findAllWithOrder();
    }





}