package spring.study.teststudy;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;
import spring.study.teststudy.domain.Study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//@ExtendWith(FindSlowTestExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
            new FindSlowTestExtension(1000L);

    int value = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

    @Test
    @Order(1)
    @DisplayName("스터디 만들기")
    @Disabled
    @FastTest
//    @Tag("fast")
//    @EnabledOnOs(OS.MAC)
//    @EnabledOnJre({JRE.JAVA_15})
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV",matches = "LOCAL")
    void create_new_study() {

//        String test_env = System.getenv("TEST_ENV");
//
//        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
//
//        assumingThat("LOCAL".equalsIgnoreCase(test_env),()->{
//            Study actual = new Study(10);
//            assertThat(actual.getLimit()).isGreaterThan(0);
//        });

        Study actual = new Study(10);
//        assertThat(actual.getLimit()).isGreaterThan(0);

//        assertTimeout(Duration.ofMillis(100),()-> {
//            new Study(10);
//            Thread.sleep(300);
//        });

//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
//        assertEquals("limit은 0보다 커야 한다.",exception.getMessage());

//        Study study = new Study(-10);
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                        () -> "스터디를 처음 만들면" + StudyStatus.DRAFT + "상태다."),
//                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다."),
//        );
    }

//    @EnabledOnJre(JRE.OTHER)
    @Test
    @DisplayName("스터디 만들기 반복")
//    @SlowTest
//    @Tag("slow")
    @Order(2)
    void create_new_study_again() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(this);
        System.out.println("create1");

    }

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10,name = "{displayName}, {currentRepetition}/{totalRepetitions}" )
    @Order(3)
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
        System.out.println(this);
        System.out.println(value++);
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @Order(4)
    @CsvSource({"10,'자바 스터디',","20,'스프링'"})
//    @NullAndEmptySource
//    @ValueSource(strings = {"날씨가", "많이","추워지고","있네요."})
//    @ValueSource(ints = {10,20,40})
    void parameterizedTest(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println(study);
        System.out.println(this);
        System.out.println(value++);
    }

    static class StudyAggregator implements ArgumentsAggregator{

        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0),accessor.getString(1));
        }
    }

    static class StudyConverter extends SimpleArgumentConverter{

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }



}