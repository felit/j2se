package com.livedrof.j2se.concurrent;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试volatile/atomic/local的正确性，性能。
 */
public class AtomicTest {
    public static final int times = 100000000;

    @Test
    public void testAtomic() throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integer.incrementAndGet();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integer.incrementAndGet();
                }

            }
        });
        t1.start();
        t2.start();
        System.out.println("不阻塞");
//        t1.join();
//        t2.join();
        Thread.sleep(10000);
        System.out.println(integer.get());
    }

    @Test
    public void testNonSecurityThread() throws InterruptedException {
        IntegerVal integerVal = new IntegerVal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                System.out.println("线程1累加完成");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                System.out.println("线程2累加完成");
            }
        });
        t1.start();
        t2.start();
        System.out.println("不阻塞");
        Thread.sleep(2000);
        System.out.println(integerVal.val);

    }

    @Test
    public void testVolatile() throws InterruptedException {
        VolatileVal integerVal = new VolatileVal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                System.out.println("线程1累加完成");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                System.out.println("线程2累加完成");
            }
        });
        t1.start();
        t2.start();
        System.out.println("不阻塞");
        Thread.sleep(2000);
        System.out.println(integerVal.val);
        Thread.sleep(2000);
        System.out.println(integerVal.val);

    }


    @Test
    public void testLock() throws InterruptedException {
        LockVal integerVal = new LockVal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                System.out.println("线程1累加完成");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long t1 = System.currentTimeMillis();
                for (int i = 0; i < times; i++) {
                    integerVal.increment();
                }
                long t2 = System.currentTimeMillis();

                System.out.println("线程2累加完成");
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(20000);
        System.out.println(integerVal.a);
    }


    public class LockVal {
        private int a = 0;
        ReentrantLock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                a++;
            } finally {
                lock.unlock();
            }
        }
    }

    public class VolatileVal {
        private volatile int val;

        public void increment() {
            this.val += 1;

        }
    }

    public class IntegerVal {
        private int val;

        public void increment() {
            this.val += 1;

        }
    }
}
