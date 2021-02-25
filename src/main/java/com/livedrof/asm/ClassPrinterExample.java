package com.livedrof.asm;


import org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 * asm 已经内嵌至jdk8中 jdk.internal.org.objectweb.asm.ClassReader
 */
public class ClassPrinterExample {
    public static void main(String args[]) throws IOException {
        ClassPrinterVisitor cp = new ClassPrinterVisitor();
        ClassReader cr = new ClassReader("java.lang.Runnable");
        cr.accept(cp,0);


    }
}
