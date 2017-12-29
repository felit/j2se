package com.livedrof.j2se.concurrent.jmm;

import org.junit.Test;

import java.util.Map;

/**
 * 导出堆栈信息
 * <p>
 * jps| grep ThreadDemo| awk '{print $1}'| xargs jstack
 * 查看线程：
 * jps| grep ThreadDemo| awk '{print $1}'| xargs pstree -p
 * find /proc/xxx/task
 */
public class ThreadDemo {
    @Test
    public void test() throws InterruptedException {
        printAllThreads();
        Thread.sleep(1000);
        System.out.println("-----------------");
        printAllThreads();
        System.out.println("-----------------");
        for (Thread t : findAllThreads()) {
            System.out.println(t.getId() + ":" + t.getName());
        }
    }

    /**
     * 打印所有线程的信息
     */
    public static void printAllThreads() {
        for (Map.Entry<Thread, StackTraceElement[]> t : Thread.getAllStackTraces().entrySet()) {
            System.out.println(t.getKey().getId() + ":" + t.getKey().getName());
        }
    }

    public static Thread[] findAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            System.out.println("线程组：" + group.getName());
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slacks = new Thread[estimatedSize];
        //获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slacks);
        Thread[] threads = new Thread[actualSize];
        System.arraycopy(slacks, 0, threads, 0, actualSize);
        return threads;
    }
}
