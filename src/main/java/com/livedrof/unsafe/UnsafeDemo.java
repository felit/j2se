package com.livedrof.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Unsafe unsafe = Unsafe.getUnsafsafe();
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
//        Unsafe unsafe = (Unsafe) f.get(UnsafeDemo.class);
        UnsafeDemo demo = (UnsafeDemo) unsafe.allocateInstance(UnsafeDemo.class);
        unsafe.park(false,0);
        System.out.println(demo);
    }
}
