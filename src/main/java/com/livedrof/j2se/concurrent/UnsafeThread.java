package com.livedrof.j2se.concurrent;

/**
 */
public class UnsafeThread {
    public int num = 900;

    public void plus() {
        num++;
    }

    public void reduce() {
        num--;
    }

    public static void main(String args[]) throws InterruptedException {
        final UnsafeThread con = new UnsafeThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    con.plus();
                }
                System.out.println(con);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    con.reduce();
                }
                System.out.println(con);
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        Thread.currentThread().sleep(2000);
        System.out.println(con.num);
    }

    @Override
    public String toString() {
        return "UnsafeThread{" +
                "num=" + num +
                '}';
    }
}
