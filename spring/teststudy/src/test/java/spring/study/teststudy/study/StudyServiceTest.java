package spring.study.teststudy.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.study.teststudy.domain.Member;
import spring.study.teststudy.domain.Study;
import spring.study.teststudy.domain.StudyStatus;
import spring.study.teststudy.service.MemberService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    private MemberService memberService;

    @Mock
    private StudyRepository studyRepository;

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

        given(studyRepository.save(study))
                .willReturn(study);

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
        given(studyRepository.save(study)).willReturn(study);

        // when
        studyService.openStudy(study);

        // then
        assertEquals(StudyStatus.OPENED,study.getStatus());
        assertNotNull(study.getOpenedDateTime());
        then(memberService).should().notify(study);

    }

}