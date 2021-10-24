package com.study.jacoco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.jacoco.dto.MemberCreateRequest;
import com.study.jacoco.dto.MemberResponse;
import com.study.jacoco.dto.MemberUpdateRequest;
import com.study.jacoco.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
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
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void init(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("회원 생성 테스트")
    void createMember() throws Exception {
        MemberCreateRequest request = new MemberCreateRequest("테스트 회원", 20);
        MemberResponse response = new MemberResponse(1L, request.getName(), request.getAge());

        // given
        given(memberService.create(any()))
                .willReturn(response);
        // when
        mockMvc.perform(post("/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));

        // then
        then(memberService).should(times(1)).create(any());
    }

    @Test
    @DisplayName("회원 수정 테스트")
    void updateMember() throws Exception{
        MemberUpdateRequest request = new MemberUpdateRequest("테스트 회원", 20);
        MemberResponse response = new MemberResponse(1L, request.getName(), request.getAge());

        // given
        given(memberService.update(any(),any()))
                .willReturn(response);

        // when
        mockMvc.perform(post("/members/{memberId}",1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));

        // then
        then(memberService).should(times(1)).update(any(),any());
    }
}