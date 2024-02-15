package org.example.junittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
     void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test" + repetitionInfo.getCurrentRepetition() + "/" +repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"유열", "노예"})
    void parameterizedTest(String message){
        System.out.println(message);
    }



}
