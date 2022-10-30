package com.livedrof.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/qq_27695659/article/details/104390088
 */
public class JolExample {
    static Object generate() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", new Integer(1));
        map.put("b", "b");
        map.put("c", new Date());

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }

    public static void main(String args[]) {
        String result = ClassLayout.parseInstance(Object.class).toPrintable();
        System.out.println(result);

        String kk = GraphLayout.parseInstance(new Object()).toPrintable();
        System.out.println(kk);




    }
}
