package com.livedrof.j2se.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        System.out.println("开始等待");
        boolean b = executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("等待完毕");
        if(b){
            System.out.println("分线程已经结束");
        }
        System.out.println(Thread.currentThread().getName());
    }
}
