package com.livedrof.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Java的LockSupport.park()实现分析
 * https://blog.csdn.net/hengyunabc/article/details/28126139
 *
 *并行编程之条件变量（posix condition variables）
 * https://blog.csdn.net/hengyunabc/article/details/27969613
 *
 * FaceBook也开源了一个C++的类库，里面也有并发数据结构
 * https://github.com/facebook/folly
 */
public class UnSafeUtil {
    private UnSafeUtil() {
    } // dummy private constructor

    /**
     * Fetch the Unsafe.  Use With Caution.
     */
    public static Unsafe getUnsafe() {
        // Not on bootclasspath
        if (UnSafeUtil.class.getClassLoader() == null)
            return Unsafe.getUnsafe();
        try {
            final Field fld = Unsafe.class.getDeclaredField("theUnsafe");
            fld.setAccessible(true);
            return (Unsafe) fld.get(UnSafeUtil.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not obtain access to sun.misc.Unsafe", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("unsafe beginning");
        UnSafeUtil.getUnsafe().park(false, 0);
        System.out.println("hello unsafe");
    }
}
