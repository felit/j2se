package com.livedrof.j2se.concurrent.threads;

public class ThreadTest {

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1 / 0);
            }
        });
        thread.start();
        Thread.sleep(1000L);
    }
}
