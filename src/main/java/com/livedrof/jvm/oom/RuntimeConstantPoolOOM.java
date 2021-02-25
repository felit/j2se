package com.livedrof.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * java -Xms20M -Xmx20M -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+HeapDumpOnOutOfMemoryError com.livedrof.jvm.oom.RuntimeConstantPoolOOM
 *
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * Dumping heap to java_pid31735.hprof ...
 * Heap dump file created [25082659 bytes in 0.215 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *         at java.lang.Integer.toString(Integer.java:403)
 *         at java.lang.String.valueOf(String.java:3099)
 *         at com.livedrof.jvm.oom.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:11)
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}