package com.livedrof.j2se.concurrent.collections;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentMapExample {
    public static void main(String args[]) {
        ConcurrentSkipListMap m= new ConcurrentSkipListMap() ;
        m.put("hello", "world");
        m.comparator();
        System.out.println(m.put("hello","h1"));
//        sun.misc.Unsafe.getUnsafe().compareAndSwapObject();
        ConcurrentMap mm;

    }
}
