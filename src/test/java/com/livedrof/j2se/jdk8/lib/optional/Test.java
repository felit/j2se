package com.livedrof.j2se.jdk8.lib.optional;

import java.math.BigDecimal;
import java.util.Optional;

public class Test {

    @org.junit.Test
    public void test(){
        BigDecimal big = new BigDecimal(0);
        Optional<BigDecimal> optional= Optional.of(new BigDecimal(0.0));
        System.out.println(Optional.ofNullable((BigDecimal)null).orElse(new BigDecimal(20)));;
        System.out.println(optional.get());
//        big.subtract(null);
    }
}
