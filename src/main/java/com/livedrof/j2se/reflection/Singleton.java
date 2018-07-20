package com.livedrof.j2se.reflection;

import java.lang.reflect.Field;

/**
 * 反射
 * http://www.cnblogs.com/noKing/p/9038234.html
 * http://freish.iteye.com/blog/1008304
 * 未成功
 */
class Singleton {
    //    volatile
    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public static void main(String args[]) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Singleton singleton = Singleton.getInstance();
                    try {
                        if (singleton != null) {
                            Field field = singleton.getClass().getDeclaredField("instance");
                            field.setAccessible(true);
                            field.set(singleton, null);
                        }
                        System.out.println("" + Thread.currentThread() + Singleton.getInstance());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Singleton singleton = Singleton.getInstance();
                    try {
                        if (singleton != null) {
                            Field field = singleton.getClass().getDeclaredField("instance");
                            field.setAccessible(true);
                            field.set(singleton, null);
                        }
                        singleton = Singleton.getInstance();
                        System.out.println("" + Thread.currentThread() + Singleton.getInstance());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(100000);
    }
}