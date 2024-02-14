package org.example.junittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

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