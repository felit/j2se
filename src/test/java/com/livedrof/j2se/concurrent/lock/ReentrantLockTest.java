package com.livedrof.j2se.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        System.out.println("lock complement");
        condition.await();
        System.out.println("await complement");
        condition.notify();
        lock.unlock();

    }
}
