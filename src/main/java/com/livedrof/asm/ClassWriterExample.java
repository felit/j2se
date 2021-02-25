package com.livedrof.asm;

import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.objectweb.asm.Opcodes.*;

/**
 * javassist: https://www.cnblogs.com/rickiyang/p/11336268.html
 * 字节码增强: https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html
 * CGLib 动态代理 Byte Buddy
 * TODO
 * 添加成员、移除成员
 * 指令操作
 */
public class ClassWriterExample {
    public static void main(String args[]) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8,
                ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable",
                null,
                "java/lang/Object",
                null);
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        ClassLoader parentClassLoader = ClassWriterExample.class.getClassLoader();
        Class newClass = new MyClassLoader(parentClassLoader).defineClass("pkg.Comparable", b);
        System.out.println(newClass);

        File file = new File("Comparable.class");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(b);
        outputStream.flush();
        outputStream.close();
    }
}
