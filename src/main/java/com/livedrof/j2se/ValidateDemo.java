package com.livedrof.j2se;

//import javax.annotation.Nonnull;

public class ValidateDemo {
    public static void main(String args[]) {
//        testNotNull(null);
        testNotNullReturn();
    }

    public static void testNotNull(String kk) {
        System.out.println("hello " + kk);
    }

    //    @Nonnull
    public static Object testNotNullReturn() {
        return null;

    }
}
