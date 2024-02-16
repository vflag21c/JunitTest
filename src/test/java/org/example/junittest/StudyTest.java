package org.example.junittest;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    /**
     * Test 마다 인스턴스가 바뀐다. 전역변수 증가 x  (ex : int value = 1 )
     * 순서도 보장되지않음.
     */

    @Test
    void create_new_study() {
        System.out.println("study");
    }

    @Test
    void create_new_study_again() {
        System.out.println("study_again");
    }

    @Test
    @DisplayName("스터디 만들기 😒\uD83D\uDE31")
    void 이모지_테스트 () {
        System.out.println("😒");
    }

}