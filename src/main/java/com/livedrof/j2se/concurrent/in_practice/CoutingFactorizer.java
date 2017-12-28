package com.livedrof.j2se.concurrent.in_practice;

import java.util.concurrent.atomic.AtomicLong;

/**
 */
public class CoutingFactorizer {
    private final AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

    public void plus() {
        count.incrementAndGet();
    }

    public static void main(String args[]) throws InterruptedException {
        final CoutingFactorizer cf = new CoutingFactorizer();
        final UnsafeCounting uc = new UnsafeCounting();
        final int num = 100000;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    cf.plus();
                    uc.plus();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    cf.plus();
                    uc.plus();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Thread.currentThread().sleep(1000);
        //这里得到的结果永远是2*num
        System.out.println(cf.getCount());
        // 这里返回错误的不确定的结果，如：199853等
        System.out.println(uc.getCount());
    }

    static class UnsafeCounting {
        private int num;

        public long getCount() {
            return num;
        }

        public void plus() {
            num++;
        }
    }
}
