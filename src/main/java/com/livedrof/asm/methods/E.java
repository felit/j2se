package com.livedrof.asm.methods;

public class E {
    public static void m() {
        System.out.println("from E: " + System.currentTimeMillis());
        String a = "a";
        a += "b";
        a += "b";
        a += "b";
        a += "b";
        a += "b";
        a += "b";
        System.out.println(a);
    }
}
