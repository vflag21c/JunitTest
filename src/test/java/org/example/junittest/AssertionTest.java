package org.example.junittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    @Test
    @DisplayName("실패 시 메시지 표출")
    void test1() {
        Study study = new Study();
        // 기대하는 값이 앞에 오고, 실제 비교로 오는값을 뒤에...
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다." );

        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "스터디를 처음 만들면 상태값이 DRAFT여야 한다.";
            }
        });

        //연산이 필요한 경우 아래 case가 유리
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 " + StudyStatus.DRAFT + "여야 한다.");
    }

    @Test
    @DisplayName("Assert문 다수 실행")
    void test2(){
        Study study = new Study();

        //Executable...
        //다수 테스트 결과 확인 가능
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다." )
        );
    }

    @Test
    @DisplayName("테스트 수행 시간 테스트")
    void test3() {
        assertTimeout(Duration.ofMillis(100), ()->{
            new Study();
//            Thread.sleep(300);
        });
    }

    
}
