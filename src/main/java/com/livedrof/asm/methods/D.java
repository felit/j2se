package com.livedrof.asm.methods;


import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class D {
    public static long timer;

    public void m() throws InterruptedException {
        java.io.PrintStream out = System.out;

        /**
         *  0: getstatic     #2   // Field java/lang/System.out:Ljava/io/PrintStream;
         *  3: invokestatic  #3   // Method java/lang/System.currentTimeMillis:()J
         *  6: invokevirtual #4   // Method java/io/PrintStream.println:(J)V
         */
        System.out.println(System.currentTimeMillis());

        timer -= System.currentTimeMillis();
        Thread.sleep(100);
        timer += System.currentTimeMillis();
        MethodVisitor mv = null;


    }
}
