package com.livedrof.j2se.concurrent.threads;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayDequeueTest {
    @Test
    public void test() {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < 100; i++) {
            deque.add(i);
        }
        System.out.println(deque.poll());
        System.out.println(deque.pop());
        System.out.println(deque.pollLast());
    }

    @Test
    public void test2() {
        ArrayBlockingQueue<Integer> deque = new ArrayBlockingQueue<Integer>(100);
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            deque.add(i);
        }

    }
}
