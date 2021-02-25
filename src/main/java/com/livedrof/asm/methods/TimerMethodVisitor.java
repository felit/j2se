package com.livedrof.asm.methods;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class TimerMethodVisitor extends MethodVisitor {
    public TimerMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
//        mv.visitCode();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        System.out.println("maxStack:" + maxStack + " maxLocals:" + maxLocals);
        super.visitMaxs(maxStack + 3, maxLocals);
    }
}
