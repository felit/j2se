package com.livedrof.j2se.concurrent.threads;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

public class RejectedExceptionTest {
    private ThreadPoolExecutor threadPoolExecutor;

    @Before
    public void setUp() {
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                FutureTask task = (FutureTask) r;
                System.out.println(executor);
            }
        };

        rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        this.threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(1), rejectedExecutionHandler);
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            this.threadPoolExecutor.submit(new Task(i));
        }
    }

    static class Task implements Runnable {
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

}
