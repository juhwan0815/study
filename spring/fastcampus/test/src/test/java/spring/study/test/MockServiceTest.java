package spring.study.test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

public class MockServiceTest {

    private MockService mockService;

    @Mock
    private MockRepsository mockRepsository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        List<Mocks> mocksList = new ArrayList<>();
        given(mockRepsository.findAllI()).willReturn(mocksList);

        mockService = new MockService(mockRepsository);
    }
    하고 테스트
}
