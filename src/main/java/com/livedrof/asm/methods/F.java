package com.livedrof.asm.methods;

public class F {
    public void hello() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(100);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime));
    }
}
