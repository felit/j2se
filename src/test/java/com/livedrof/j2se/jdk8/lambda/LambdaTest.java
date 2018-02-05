package com.livedrof.j2se.jdk8.lambda;

import org.junit.Test;

public class LambdaTest {
    /**
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     */
    @Test
    public void test() {
        new Thread(() -> {
            System.out.println("In Java8, Lambda expression rocks !!");
            System.out.println(this);
        }).start();
    }

}
