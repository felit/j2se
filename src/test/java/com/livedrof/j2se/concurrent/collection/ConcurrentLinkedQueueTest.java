package com.livedrof.j2se.concurrent.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

public class ConcurrentLinkedQueueTest {
    private ConcurrentLinkedQueue<String> queue;
    private int count = 100000;
    private int count2 = 2;
    private CountDownLatch cd = new CountDownLatch(count2);

    @Before
    public void setUp() {
        queue = new ConcurrentLinkedQueue<>();
    }

    @Test
    public void testEmpty() {
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(26858.0 / 799);
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        ThreadPoolExecutor executor;

        doThis();
        for (int i = 0; i < count2; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
//                    while (queue.size() > 0) {
                    while (!queue.isEmpty()) {
                        //TODO 空语句，不退出
                        System.out.println("" + queue.poll() + "\t" + Thread.currentThread());
//                        continue;
                    }
                    cd.countDown();
                }
            });
        }
        cd.await();
        es.shutdown();
    }

    public void doThis() {
        for (int i = 0; i < count; i++) {
            queue.offer("" + i);
        }
    }
}
