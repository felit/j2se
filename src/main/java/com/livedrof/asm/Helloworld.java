package com.livedrof.asm;

public class Helloworld {
    public void sayHello() {
        try {
            Thread.sleep(2*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
