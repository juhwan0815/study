package spring.study.teststudy.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.ILoggerFactory;
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
import spring.study.teststudy.domain.Member;
import spring.study.teststudy.domain.Study;
import spring.study.teststudy.domain.StudyStatus;
import spring.study.teststudy.service.MemberService;

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
class StudyServiceTest {

    Logger logger = LoggerFactory.getLogger(StudyServiceTest.class);

    @Autowired
    Environment env;

    @Value("${container.port}")
    int value;

    @Mock
    private MemberService memberService;

    @Autowired
    private StudyRepository studyRepository;

//    @Container
//    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
//            .withDatabaseName("studytest");

//    @Container
//    static GenericContainer postgreSQLContainer = new GenericContainer("postgres")
//            .withExposedPorts(5432)
//            .withEnv("POSTGRES_DB","studytest");
//            .waitingFor(Wait.forListeningPort())
//            .waitingFor(Wait.forHttp("/hello"));
//
    @Container
    static DockerComposeContainer composeContainer =
        new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
        .withExposedService("study-db",5432);

    static class ContainerPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("container.port=" + composeContainer.getServicePort("study-db",5432))
                    .applyTo(applicationContext.getEnvironment());
        }
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("---------------");
//        System.out.println(postgreSQLContainer.getMappedPort(5432));
//        System.out.println(postgreSQLContainer.getLogs());\
        studyRepository.deleteAll();
    }
//
    @BeforeAll
    static void beforeAll(){
//        postgreSQLContainer.start();
//        System.out.println(postgreSQLContainer.getJdbcUrl());

    }

//    @AfterAll
//    static void afterAll(){
//        postgreSQLContainer.stop();
//    }

    @Test
    void createNewStudy() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

//        when(memberService.findById(any())).thenReturn(Optional.of(member));
        when(memberService.findById(any())).thenReturn(Optional.of(member));

        assertEquals("keesun@gmail.com", memberService.findById(1L).get().getEmail());
        assertEquals("keesun@gmail.com", memberService.findById(2L).get().getEmail());

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(IllegalArgumentException.class, () -> memberService.validate(1L));
        memberService.validate(2L);
//        when(memberService.findById(1L)).thenThrow(new RuntimeException());

    }

    @Test
    void createStudy() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        System.out.println(value);
        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

//        when(memberService.findById(any())).thenReturn(Optional.of(member));
        when(memberService.findById(any()))
                .thenReturn(Optional.of(member)) // 첫번째 호출
                .thenThrow(new RuntimeException()) // 2번째 호출
                .thenReturn(Optional.empty()); // 3번째 호출

        Optional<Member> byId = memberService.findById(1L);
        assertEquals("keesun@gmail.com",byId.get().getEmail());

        assertThrows(RuntimeException.class, () -> {
            memberService.findById(2L);
        });

        assertEquals(Optional.empty(), memberService.findById(3L));
    }

    @Test
    void practice() {
        // given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10,"테스트");

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

//        when(memberService.findById(1L))
//                .thenReturn(Optional.of(member));
//
//        when(studyRepository.save(study))
//                .thenReturn(study);

        given(memberService.findById(1L))
                .willReturn(Optional.of(member));

//        given(studyRepository.save(study))
//                .willReturn(study);

        // when
        studyService.createNewStudy(1L,study);


        // then
        assertNotNull(study.getOwner());

        verify(memberService,times(1)).notify(study);
        then(memberService).should(times(1)).notify(study);

        verifyNoMoreInteractions(memberService); // 어떠한 인터렉션도 일어나면 안된다.
        then(memberService).shouldHaveNoMoreInteractions();
//        verify(memberService,times(1)).notify(member);
//
//        verify(memberService,never()).validate(any());
//
//         순차
//        InOrder inOrder = inOrder(memberService);
//        inOrder.verify(memberService).notify(study);

    }


    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void openStudy(){
        // given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");
        assertNull(study.getOpenedDateTime());
//        given(studyRepository.save(study)).willReturn(study);

        // when
        studyService.openStudy(study);

        // then
        assertEquals(StudyStatus.OPENED,study.getStatus());
        assertNotNull(study.getOpenedDateTime());
        then(memberService).should().notify(study);

    }

}