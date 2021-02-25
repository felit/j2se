package com.livedrof.jvm.oom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList:
 * congshuanglongdeMacBook-Pro:classes congsl$ java -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError com.livedrof.jvm.oom.HeapOOM
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * Dumping heap to java_pid29999.hprof ...
 * Heap dump file created [36688646 bytes in 0.244 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *         at java.util.LinkedList.linkLast(LinkedList.java:142)
 *         at java.util.LinkedList.add(LinkedList.java:338)
 *         at com.livedrof.jvm.oom.HeapOOM.main(HeapOOM.java:15)
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }
}
