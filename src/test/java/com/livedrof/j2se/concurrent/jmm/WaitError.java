package com.livedrof.j2se.concurrent.jmm;

/**
 * Exception in thread "Thread-0" Exception in thread "Thread-1" Exception in thread "Thread-2" java.lang.IllegalMonitorStateException
 * at java.lang.Object.wait(Native Method)
 * at java.lang.Object.wait(Object.java:502)
 * at com.livedrof.j2se.concurrent.jmm.WaitError$Wait.run(WaitError.java:25)
 * at java.lang.Thread.run(Thread.java:745)
 * java.lang.IllegalMonitorStateException
 * at java.lang.Object.notify(Native Method)
 * at com.livedrof.j2se.concurrent.jmm.WaitError$1.run(WaitError.java:12)
 * at java.lang.Thread.run(Thread.java:745)
 * java.lang.IllegalMonitorStateException
 * at java.lang.Object.wait(Native Method)
 * at java.lang.Object.wait(Object.java:502)
 * at com.livedrof.j2se.concurrent.jmm.WaitError$Wait.run(WaitError.java:25)
 * at java.lang.Thread.run(Thread.java:745)
 */
public class WaitError {
    private static Object lock = new Object();

    public static void main(String args[]) {
        Thread wait = new Thread(new Wait(), "waiting-1");
        Thread wait2 = new Thread(new Wait(), "waiting-2");
        Thread notify = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    lock.notifyAll();
                    System.out.println("notify all lock");
                }
            }
        },"Notify all thread");
        long beginTime = System.currentTimeMillis();
        wait.start();
        long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:"+(endTime-beginTime));
        wait2.start();
        notify.start();
        SleepUtils.second(3);
        System.out.println("after sleep");
        Thread t = new Thread(new Wait(), "after-waiting-2");
        t.start();
//        t.interrupt();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            SleepUtils.second(1);
            try {
                synchronized (lock) {
                    lock.wait();
                }
                System.out.println("wait complement");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
