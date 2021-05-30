package spring.study.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;

    @Autowired
    private ExceptionHandler exceptionHandler;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(personController)
                .setControllerAdvice(exceptionHandler)
                .setMessageConverters 도 가능
                .alwaysDo(MockMvcResultHandlers.print())
                .build();

        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    void mockMvcTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("helloWorld"));
    }

    @Test
    void postPerson() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n"
                        + " \"name\":\"martin2\",\n"
                        + " \"age\":\"20\",\n"
                        + " \"bloodType\":\"A\",\n"
                        + "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAll() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("martin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value("david"));
    }

    @Test
    void list() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().
                        string(containsString("\"id\":1004")));
    }
}