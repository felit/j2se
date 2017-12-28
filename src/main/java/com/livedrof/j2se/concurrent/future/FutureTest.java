package com.livedrof.j2se.concurrent.future;

import java.util.concurrent.*;

/**
 */
public class FutureTest {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        System.out.println(result.get());
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        }
    }
}
