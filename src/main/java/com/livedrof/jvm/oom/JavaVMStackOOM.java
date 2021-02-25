package com.livedrof.jvm.oom;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

/**
 *  java -Xms20M -Xmx20M -Xss2M -XX:+HeapDumpOnOutOfMemoryError com.livedrof.jvm.oom.JavaVMStackOOM
 * Java获取系统内存、CPU、磁盘等信息
 * https://www.cnblogs.com/rvs-2016/p/11169894.html
 */
public class JavaVMStackOOM {
    static long num=0;
    static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    private static void printMomeryInfo() {
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
        long initTotalMemorySize = memoryUsage.getInit();
        long maxMemorySize = memoryUsage.getMax();
        long usedMemorySize = memoryUsage.getUsed();
        System.out.println("maxMemorySize:" + maxMemorySize / 1024.0 + "k");
        System.out.println("usedMemorySize:" + usedMemorySize / 1024.0 + "k");
    }

    private void dontStop() {
        while (true) {
            num += 1;
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
            /**
             * 查看信息
             */
            System.out.println(thread.getName());
            printMomeryInfo();
        }
    }

    public static void main(String args[]) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
