package com.livedrof.j2se.concurrent.threads;

public class Task implements Runnable {
    private Integer number;
    private Integer sleepMs;

    public Task(Integer number) {
        this(number, 1);

    }

    public Task(Integer number, Integer sleepMs) {
        this.number = number;
        this.sleepMs = sleepMs;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("---------completely------");
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                '}';
    }
}
