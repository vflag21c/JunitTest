package org.example.junittest.mocktest;

import org.example.domain.Member;
import org.example.junittest.Study;
import org.example.junittest.StudyRepository;
import org.example.junittest.StudyService;
import org.example.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StubbingTest {


    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createNewStudy(){
        Study study = new Study(10, "테스트");
        StudyService studyService = new StudyService(memberService, studyRepository);

        assertNotNull(studyService);

        //1. MemberService 객체에 findById 메소드를 1L 값으로 호출하면 member 객체를 리턴하도록 Stubbing
        Member member = new Member();
        member.setId(1L);
        member.setEmail("youyeol@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        //2. studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체로 그대로 리턴하도록 Stubbing
        when(studyRepository.save(study)).thenReturn(study);
    }

    @Test
    void Mock_객체_확인(){
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("youyeol@naver.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        verify(memberService, times(1)).notify(study); // notify 메소드 호출 count 확인
    }
}
