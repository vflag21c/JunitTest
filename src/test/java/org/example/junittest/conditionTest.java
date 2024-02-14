package org.example.junittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.*;

public class conditionTest {

    @Test
    @DisplayName("조건에 따른 수행")
    void test1(){
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equals(test_env));

        // 아래 코드는 수행 안됨.
        Study study = new Study();
        Assertions.assertNotNull(study);
    }

    @Test
    @DisplayName("조건에 따른 수행2")
    void test2(){
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);

        assumingThat("LOCAL1".equals(test_env), () ->{
            System.out.println("create");
            Study study = new Study();
            Assertions.assertNotNull(study);
        });

        assumingThat("yeol".equals(test_env), () ->{
            System.out.println("creat2");
        });
    }

    @Test
    @DisplayName("어노테이션 조건")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "local")
    void test2_1(){
        String test_env = System.getenv("TEST_ENV");
        assumeTrue("LOCAL".equals(test_env));
    }

    @Test
    @DisplayName("OS에 따른 수행")
    @DisabledOnOs(OS.LINUX)
    void test3(){
        System.out.println("Window");
    }


    @Test
    @DisplayName("JAVA 버전에 따른 수행")
    @EnabledOnJre({JRE.JAVA_8})
    void test4(){
        System.out.println("java");
    }
}
