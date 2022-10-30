package com.livedrof.asm.methods;

import com.livedrof.asm.ClassWriterExample;
import com.livedrof.asm.MyClassLoader;
import org.objectweb.asm.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class UpdateClassExample {
    public static void main(String args[]) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * TODO 字节码增强有哪些位置；及各种方法
         * 1、读取class文件
         * 2、修改类方法
         * 3、写入文件
         * 4、生成类信息
         * 5、生成类实例并调用相应的方法
         */
        // 过滤链
        ClassWriter writer = new ClassWriter(0);
        ClassVisitor visitor = new TimerClassVisitor(ASM4,writer);
        // 修改类方法
//        MethodVisitor mv = visitor.visitMethod(Opcodes.ACC_PUBLIC,"mm","()V",null,new String[]{"java/lang/InterruptedException"});
//        mv.visitCode();
//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
//        mv.visitLdcInsn(" 测试asm");
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
//        mv.visitInsn(Opcodes.RETURN);
//        mv.visitMaxs(893,1);
//        mv.visitEnd();

        String filename = "/Users/congsl/work/self/j2se/target/classes/com/livedrof/asm/methods/C.class";
        byte[] classBytes = getBytesFromFile(filename);
        ClassReader classReader = new ClassReader(classBytes);
        classReader.accept(visitor,EXPAND_FRAMES);

        byte[] bb = writer.toByteArray();

        /**
         * Class cKlass = new MyClassLoader(parentClassLoader).defineClass("com.livedrof.asm.methods.C", classBytes);
         * C cc = (C) cKlass.newInstance();
         * cc.m();
         */
        ClassLoader parentClassLoader = ClassWriterExample.class.getClassLoader();
        Class newClass = new MyClassLoader(parentClassLoader).defineClass("com.livedrof.asm.methods.C", bb);
//        newClass.newInstance().getClass().getMethod()

        //调用实例方法
//        Object instance = newClass.newInstance();
//        newClass.getMethod("m").invoke(instance);

        File file = new File("C.class");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bb);
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 读取文件至byte数组中
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] getBytesFromFile(String filename) throws IOException {
        File file = new File(filename);
        FileInputStream out = new FileInputStream(file);
        System.out.println("file.length():" + file.length());
        byte[] classBytes = new byte[new Long(file.length()).intValue()];
        int index = 0;
        while (true) {
            int bytew = out.read();
            if (bytew == -1) {
                break;
            }
//            System.out.println((byte) (bytew & 0xFF) + ":" + bytew);
            classBytes[index++] = (byte) (bytew & 0xFF);
        }
        return classBytes;
    }
}
