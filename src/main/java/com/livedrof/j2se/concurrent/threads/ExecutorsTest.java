package com.livedrof.j2se.concurrent.threads;

import java.util.ArrayDeque;
import java.util.concurrent.*;

/**
 * - ConcurrentHashMap
 - ConcurrentSkipListMap
 - ConcurrentSkipListSet
 - ConcurrentLinkedQueue
 - ConcurrentLinkedDeque
 - CopyOnWriteArrayList
 - CopyOnWriteArraySet
 */
public class ExecutorsTest {
    private static LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
    //java.lang.IllegalStateException: Queue full
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(100);

    public static void main(String args[]) {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) executors;

        for (int i = 0; i < 100000; i++) {
            executors.submit(new Task());
//            System.out.println(i);
            System.out.println(executor);
            blockingQueue.add(i);
            arrayBlockingQueue.add(i);
        }
        System.out.println(executor.getActiveCount());
        executor.shutdown();


    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("---------completely------"+blockingQueue.poll());
        }
    }

}
