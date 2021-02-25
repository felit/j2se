package com.livedrof.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * TODO
 * 1、new对象的过程
 * 2、创建实例的方法：new实例化
 * 3、锁升级的触发条件是？
 * 4、GC标记存储在哪里
 * 5、GC过程代码；怎么释放内存的
 */
public class LockExample01 {
    public static void main(String args[]) throws InterruptedException {
        Thread.sleep(5000);
        Object object = new Object();
        //打印对象信息
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}