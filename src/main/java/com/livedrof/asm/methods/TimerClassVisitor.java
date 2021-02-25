package com.livedrof.asm.methods;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

public class TimerClassVisitor extends ClassVisitor {
    public TimerClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrapperMV = mv;
        if (mv!=null&&name.equals("m")) {
            wrapperMV = new TimerMethodVisitor(ASM4, mv);
        }
        return wrapperMV;
    }
}
