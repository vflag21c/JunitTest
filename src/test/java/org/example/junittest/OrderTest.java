package org.example.junittest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    /**
     * 상태를 공유하고, 시나리오 테스트 같은 경우 사용.
     */

    @Order(1)
    @Test
    void test1(){
        System.out.println(1);
    }

    @Order(2)
    @Test
    void test2(){
        System.out.println(2);
    }
}
