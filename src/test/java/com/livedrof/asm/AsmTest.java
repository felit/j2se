package com.livedrof.asm;

import org.junit.Test;
import org.objectweb.asm.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AsmTest {
    @Test
    public void test() throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String className = "com.livedrof.asm.Helloworld";
        String klassFilename = "/Users/congsl/work/self/j2se/target/classes/com/livedrof/asm/Helloworld.class";
        InputStream inputStream = new FileInputStream(klassFilename);
        ClassReader reader = new ClassReader(inputStream);
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor change = new ChangeVisitor(writer);
        reader.accept(change, ClassReader.EXPAND_FRAMES);

        Class clazz = new MyClassLoader().defineClass(className, writer.toByteArray());
        Object personObj = clazz.newInstance();
        Method nameMethod = clazz.getDeclaredMethod("sayHello", null);
        nameMethod.invoke(personObj, null);
        System.out.println("Success!");
        byte[] code = writer.toByteArray();
        String helloworld2 = "/Users/congsl/work/self/j2se/target/classes/com/livedrof/asm/Helloworld2.class";
        FileOutputStream fos = new FileOutputStream(helloworld2);
        fos.write(code);
        fos.close();
        System.out.println(new Long("1") == 1L);
    }

    static class ChangeVisitor extends ClassVisitor {

        public ChangeVisitor(ClassVisitor cv) {
            super(Opcodes.ASM5, cv);
        }
    }
    static class MyClassLoader extends ClassLoader {
        public Class defineClass(String className, byte[] in) {
            //TODO
            return null;
        }
    }
}
