package com.example.practicetest.controller;

import com.example.practicetest.domain.Member;
import com.example.practicetest.exception.MemberException;
import com.example.practicetest.model.member.MemberSaveRequest;
import com.example.practicetest.model.member.MemberUpdateRequest;
import com.example.practicetest.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @MockBean
    private MemberService memberService;


    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("회원 가입")
    void saveMember() throws Exception {
        MemberSaveRequest memberSaveRequest = new MemberSaveRequest();
        memberSaveRequest.setEmail("juwom0831@naver.com");
        memberSaveRequest.setName("황주환");
        memberSaveRequest.setPhoneNumber("010-2058-4660");

        String body = objectMapper.writeValueAsString(memberSaveRequest);

        given(memberService.saveMember(any(MemberSaveRequest.class)))
                .willReturn(1L);

        mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated());

        then(memberService).should(times(1)).saveMember(any());
    }


    @Test
    @DisplayName("회원 중복 가입시 오류 발생")
    void saveDuplicatedMember() throws Exception {
        MemberSaveRequest memberSaveRequest = new MemberSaveRequest();
        memberSaveRequest.setEmail("juwom0831@naver.com");
        memberSaveRequest.setName("황주환");
        memberSaveRequest.setPhoneNumber("010-2058-4660");

        String body = objectMapper.writeValueAsString(memberSaveRequest);

        given(memberService.saveMember(memberSaveRequest))
                .willReturn(1L)
                .willThrow(MemberException.class);

        mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body))
                .andExpect(status().isBadRequest());

        then(memberService).should(times(2))
                .saveMember(any());
    }

    @Test
    @DisplayName("회원 수정")
    void updateMember() throws Exception {
        Member member = Member.createMember("juwom0831@naver.com", "황철원", "010-3598-1748");

        MemberUpdateRequest memberUpdateRequest = new MemberUpdateRequest();
        memberUpdateRequest.setName("황철원");
        memberUpdateRequest.setPhoneNumber("010-3598-1748");

        String body = objectMapper.writeValueAsString(memberUpdateRequest);

        given(memberService.updateMember(any(), any()))
                .willReturn(member);

        mockMvc.perform(patch("/members/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("황철원"))
                .andExpect(jsonPath("$.phoneNumber").value("010-3598-1748"));

        then(memberService).should(times(1)).updateMember(any(), any());
    }

    @Test
    @DisplayName("회원 삭제")
    void deleteMember() throws Exception {
        mockMvc.perform(delete("/members/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원 ID 조회")
    void findMemberById() throws Exception {
        Member member = Member.createMember("juwom0831@naver.com", "황철원", "010-3598-1748");

        given(memberService.findMemberById(any()))
                .willReturn(member);

        mockMvc.perform(get("/members/1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("juwom0831@naver.com"))
                .andExpect(jsonPath("$.name").value("황철원"))
                .andExpect(jsonPath("$.phoneNumber").value("010-3598-1748"));

        then(memberService).should(times(1)).findMemberById(any());
    }

    @Test
    @DisplayName("회원 모두 조회")
    void findMembers() throws Exception {
        Member member1 = Member.createMember("juwom0831@naver.com", "황주환", "010-3598-1748");
        Member member2 = Member.createMember("juwom0831@naver.com", "황철원", "010-3598-1748");

        given(memberService.findMembers())
                .willReturn(Arrays.asList(member1, member2));

        mockMvc.perform(get("/members")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("황주환"));
    }

}