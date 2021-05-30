package spring.study.test.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring.study.test.repository.HelloWorldRepository;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

@org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest(HelloWorldController.class)
public class WebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean(HelloWorldRepository.class) // 빈을 스파이로 넣어줄수잇다.
    private HelloWorldRepository helloWorldRepository;

    @MockBean
    private HelloWorldService helloWorldService;

    @Test
    public void list() throws Exception{
        List<Hello> helloList = new ArrayList<>();
        helloList.add(new Hello());

        given(helloWorldService.getHellos()) // mockBean의 행동을 처리
                .willReturn(helloList);

        mockMvc.perform(MockMvcRequestBuilders.get("/hellos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
