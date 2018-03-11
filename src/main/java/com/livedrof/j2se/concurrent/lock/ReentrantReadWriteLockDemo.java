package com.livedrof.j2se.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    public static void main(String args[]) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
        lock.writeLock().lock();
        System.out.println(lock.writeLock());
        lock.readLock().lock();
        lock.readLock().unlock();
    }
}
