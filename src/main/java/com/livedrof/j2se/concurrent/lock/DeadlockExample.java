package com.livedrof.j2se.concurrent.lock;

//import sun.nio.ch.SelectorImpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String args[]) {
//        SelectorImpl se;
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {LockSupport w;
                    lock1.lock();
                    Thread.sleep(10000);
                    lock2.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                }
            }
        },"lock-thread1");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.lock();
                    Thread.sleep(10000);
                    lock1.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                    lock1.unlock();
                }
            }
        },"lock-thread2");
        a.start();
        b.start();
    }
}
