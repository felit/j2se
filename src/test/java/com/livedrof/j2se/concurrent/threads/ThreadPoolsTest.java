package com.livedrof.j2se.concurrent.threads;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolsTest {
    private ExecutorService executor;

    @Before
    public void setup() {
        executor = Executors.newSingleThreadExecutor();
        executor = Executors.newScheduledThreadPool(2);

    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Task task = new Task(i, 20);
            this.executor.submit(task);
        }
        Thread.sleep(1000);
    }
}
