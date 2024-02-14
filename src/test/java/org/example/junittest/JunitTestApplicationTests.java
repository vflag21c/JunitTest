package org.example.junittest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class JunitTestApplicationTests {

    /**
     * 최초 시작전 한번만 실행 됨.
     * static method
     * return type : null
     */
    @BeforeAll
    static void beforeAll(){
        Study study = new Study();
        assertNotNull(study);

        System.out.println("Create");
    }

    /**
     * beforeAll > BeforeEach
     */
//    @BeforeEach

    @Test
    void create1() {
        System.out.println("Create1");
    }

    @Test
    @Disabled
    void create2() {
        //실행안됨.
    }


}
