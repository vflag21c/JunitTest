package org.example.junittest.mocktest;

import org.example.domain.Member;
import org.example.junittest.Study;
import org.example.junittest.StudyRepository;
import org.example.junittest.StudyService;
import org.example.junittest.StudyStatus;
import org.example.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BDDTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void BDD(){

        /**
         * BDD : 애플리케이션이 어떻게 "행동"해야 하는지에 대한 공통된 이해를 구성하는 방법으로, TDD에서 창안했다.
         */

        StudyService studyService = new StudyService(memberService, studyRepository);

        //Given
        Member member = new Member();
        member.setId(1L);
        member.setEmail("youyeol@naver.com");

        Study study = new Study(10, "테스트");


//        when(memberService.findById(1L)).thenReturn(Optional.of(member));
//        when(studyRepository.save(study)).thenReturn(study);
        //BDD 스타일로 작성
        given(memberService.findById(1L)).willReturn(Optional.of(member));

        //When
        studyService.createNewStudy(1L, study);

        //Then

        //verify(memberService, times(1)).notify(study);
        //BDD 스타일로 작성
        then(memberService).should(times(1)).notify(study);
    }



    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void 연습문제() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");

        // 문제1 studyRepository Mock 객체의 save 메소드를호출 시 study를 리턴하도록 만들기.
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.openStudy(study);

        // Then
        // 문제2 study의 status가 OPENED로 변경됐는지 확인
        assertEquals(StudyStatus.OPENED, study.getStatus());

        // 문제3 study의 openedDataTime이 null이 아닌지 확인
        assertNotNull(study.getOpenedDateTime());

        // 문제4 memberService의 notify(study)가 호출 됐는지 확인.
        then(memberService).should().notify(study);
    }


}
