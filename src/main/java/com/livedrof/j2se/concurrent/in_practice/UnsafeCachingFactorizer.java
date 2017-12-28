package com.livedrof.j2se.concurrent.in_practice;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 */
public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void service(BigInteger num) {
        if (num.equals(lastNumber.get())) {
            System.out.println(lastFactors.get());
        } else {
            BigInteger[] factors = factor(num);
            lastNumber.set(num);
            lastFactors.set(factors);
        }
    }

    public BigInteger[] factor(BigInteger num) {
        return new BigInteger[]{};
    }
}
