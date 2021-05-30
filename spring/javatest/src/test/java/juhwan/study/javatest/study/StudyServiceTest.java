package juhwan.study.javatest.study;

import juhwan.study.javatest.domain.Member;
import juhwan.study.javatest.domain.Study;
import juhwan.study.javatest.domain.StudyStatus;
import juhwan.study.javatest.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@Testcontainers
@ContextConfiguration(initializers = StudyServiceTest.ContainerPropertyInitializer.class)
//@Slf4j
//@Slf4j
class StudyServiceTest {

    @Mock
    private MemberService memberService;

    @Autowired
    private StudyRepository studyRepository;

    @Autowired
    Environment environment;

    @Value("${container.port}")
    int port;

    @Container
    static DockerComposeContainer composeContainer
            = new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
            .withExposedService("study-db",5432);

//    @BeforeAll
//    static void beforeAll(){
//        Slf4jLogConsumer logConsumer = new Slf4jLogConsumer(log);
//        postgreSQLContainer.followOutput(logConsumer);
//    }

    static class ContainerPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("container.port=" + composeContainer.getServicePort("study-db",5432))
                    .applyTo(applicationContext.getEnvironment());
        }
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("-----------------");

        studyRepository.deleteAll();
    }

//    @BeforeAll
//    static void beforeAll(){
//        postgreSQLContainer.start();
//        System.out.println(postgreSQLContainer.getJdbcUrl());
//    }
//
//    @AfterAll
//    static void afterAll() {
//        postgreSQLContainer.stop();
//    }

    @Test
    void createStudy() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);



        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@email.com");

        Study study = new Study(10, "java");

        given(memberService.findById(1L))
                .willReturn(Optional.of(member));

        // When
        studyService.createNewStudy(1L, study);

        // Then
        assertEquals(1L, study.getOwnerId());
        then(memberService).should(times(1)).notify(study);
        then(memberService).shouldHaveNoMoreInteractions();
    }

    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void openStudy() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");
        assertNull(study.getOpenedDateTime());

        // When
        studyService.openStudy(study);

        // Then
        // TODO study의 status가 OPENED로 변경됐는지 확인
        assertEquals(StudyStatus.OPENED, study.getStatus());
        // TODO study의 openedDataTime이 null이 아닌지 확인
        assertNotNull(study.getOpenedDateTime());
        // TODO memberService의 notify(study)가 호출 됐는지 확인.
        then(memberService).should().notify(study);
    }
}
