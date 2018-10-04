package com.livedrof.j2se.concurrent.threads;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class BlockingQueueTest {
    @Test
    public void test() {
        BlockingQueue<Long> queue = new LinkedBlockingQueue<>();
        queue.add(1L);
        queue.add(2L);
        queue.add(3L);
        queue.add(4L);
        System.out.println(queue.stream().collect(Collectors.toList()));
        System.out.println(queue.stream().collect(Collectors.toList()));
        Collection<Long> ll = new ArrayList<>(100);
        queue.drainTo(ll);
        System.out.println(ll);
        Collection<Long> l2 = new ArrayList<>(100);
        queue.drainTo(l2);
        System.out.println(l2);
        queue.add(5L);
        queue.add(6L);
        queue.drainTo(l2);
        System.out.println(l2);

    }
}
