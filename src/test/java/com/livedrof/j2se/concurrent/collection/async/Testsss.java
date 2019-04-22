package com.livedrof.j2se.concurrent.collection.async;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * Future
 * CompletionStage
 * ForkJoinPool.commonPool()
 */
public class Testsss {
    @Test
    public void thenApply() {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").join();
        System.out.println(result);
    }
}
