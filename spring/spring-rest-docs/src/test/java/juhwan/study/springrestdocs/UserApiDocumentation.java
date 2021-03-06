package juhwan.study.springrestdocs;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest
public class UserApiDocumentation {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(RestDocumentationContextProvider restDocumentation){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void testRead() throws Exception {
        mockMvc.perform(get("/api/users/{id}",1))
                .andDo(print())
                .andDo(document("user",
                        pathParameters(
                        parameterWithName("id").description("????????? id")
                        )
                        ,responseFields(
                                fieldWithPath("resultCode").description("????????????"),
                                fieldWithPath("data.id").description("id"),
                                fieldWithPath("data.account").description("??????"),
                                fieldWithPath("data.email").description("?????????"),
                                fieldWithPath("data.phoneNumber").description("????????????"),
                                fieldWithPath("data.createdAt").description("????????????"),
                                fieldWithPath("data.updatedAt").description("????????????")
                        )));

        mockMvc.perform(get("/api/users/{id}",1))
                .andDo(document("user",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        resource(
                                ResourceSnippetParameters.builder()
                                .description("???????????? ????????? ??????/??????/??????/???????????????.")
                                .summary("????????? ??????")
                                .pathParameters(
                                        parameterWithName("id").description("????????? id")
                                )
                                .responseFields(
                                        fieldWithPath("resultCode").description("????????????"),
                                        fieldWithPath("data.id").description("id"),
                                        fieldWithPath("data.account").description("??????"),
                                        fieldWithPath("data.email").description("?????????"),
                                        fieldWithPath("data.phoneNumber").description("????????????"),
                                        fieldWithPath("data.createdAt").description("????????????"),
                                        fieldWithPath("data.updatedAt").description("????????????")
                                ).build()
                        )
                ));
    }

}
