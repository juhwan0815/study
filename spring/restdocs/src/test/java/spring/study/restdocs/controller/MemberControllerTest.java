package spring.study.restdocs.controller;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spring.study.restdocs.domain.Member;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(WebApplicationContext wac,
                      RestDocumentationContextProvider restDocumentationContextProvider) {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .alwaysDo(print())
                .addFilters()
                .apply(documentationConfiguration(restDocumentationContextProvider)
                        .operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint()))
                .build();
    }

    @Test
    void testPath() throws Exception {
        mockMvc.perform(get("/api/members/{memberId}", 1)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(document("member/readPath",
                        pathParameters(
                                parameterWithName("memberId").description("?????? Id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("?????? Id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("?????? ??????")
                        ))
                )
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/members/{memberId}",1))
                .andDo(document("member", // openAPI3 document
                        resource(
                                ResourceSnippetParameters.builder()
                                        .description("???????????? ????????? ??????/??????/??????/???????????????.")
                                        .summary("????????? ??????")
                                        .pathParameters(
                                                parameterWithName("memberId").description("????????? id")
                                        )
                                        .responseFields(
                                                fieldWithPath("id").description("?????? Id"),
                                                fieldWithPath("name").description("?????? ??????")
                                        ).build()
                        )
                ));
    }

    @Test
    void testParam() throws Exception {
        mockMvc.perform(get("/api/members")
                .param("memberId", "1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(document("member/readParam", // openSource??? document
                        requestParameters(
                                parameterWithName("memberId").description("??????Id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("?????? Id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("?????? ??????")
                        ))
                )
                .andExpect(status().isOk());
    }

    @Test
    void testBody() throws Exception {

        Member member = new Member(100L, "?????????");

        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/members")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member))
        ).andDo(document("member/create",
                requestFields(
                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("?????? Id"),
                        fieldWithPath("name").type(JsonFieldType.STRING).description("?????? ??????")
                ),
                responseFields(
                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("?????? Id"),
                        fieldWithPath("name").type(JsonFieldType.STRING).description("?????? ??????")
                ))
        )
                .andExpect(status().isOk());
    }

    @Test
    void testHeader() throws Exception {
        mockMvc.perform(get("/api/members/header")
                .header("memberId", "1"))
                .andDo(document("member/header",
                        requestHeaders(
                                headerWithName("memberId").description("?????? Id")
                        ),
                        responseHeaders(
                                headerWithName("memberId").description("?????? Id")
                        )
                ))
                .andExpect(header().string("memberId", "1"));
    }
}