package com.livedrof.j2se.concurrent.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String args[]) {
        System.out.println("-----------");
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        synchronized (new Object()) {

        }
        Executor executor;
    }
}
