package com.livedrof.guava;
import com.google.common.hash.Hashing;
import org.junit.Test;

public class HashingTest {
    @Test
    public void test() {
        Hashing.consistentHash(1000L, 2);
    }

}
