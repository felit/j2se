package com.livedrof.asm.methods;

import org.objectweb.asm.*;

public class TimerProxyClassVisitor extends MethodVisitor {
    private String version;

    public TimerProxyClassVisitor(String version, int api, MethodVisitor mv) {
        super(api, mv);
        this.version = version;
    }

    @Override
    public void visitParameter(String name, int access) {
        super.visitParameter(name, access);
        System.out.println("TimerProxyClassVisitor." + version + "#visitParameter");
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        System.out.println("TimerProxyClassVisitor." + version + "#visitAnnotationDefault");
        return super.visitAnnotationDefault();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitAnnotation");
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitTypeAnnotation");
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitParameterAnnotation");
        return super.visitParameterAnnotation(parameter, desc, visible);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitAttribute");
        super.visitAttribute(attr);
    }

    @Override
    public void visitCode() {
        System.out.println("TimerProxyClassVisitor." + version + "#visitCode");
        super.visitCode();
    }

    @Override
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitFrame");
        super.visitFrame(type, nLocal, local, nStack, stack);
    }

    @Override
    public void visitInsn(int opcode) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitInsn");
        super.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitIntInsn");
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitVarInsn");
        super.visitVarInsn(opcode, var);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitTypeInsn");
        super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitFieldInsn");
        super.visitFieldInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitMethodInsn");
        super.visitMethodInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitMethodInsn");
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitInvokeDynamicInsn");
        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitJumpInsn");
        super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLabel(Label label) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLabel");
        super.visitLabel(label);
    }

    @Override
    public void visitLdcInsn(Object cst) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLdcInsn");
        super.visitLdcInsn(cst);
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitIincInsn");
        super.visitIincInsn(var, increment);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitTableSwitchInsn");
        super.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLookupSwitchInsn");
        super.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitMultiANewArrayInsn");
        super.visitMultiANewArrayInsn(desc, dims);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitInsnAnnotation");
        return super.visitInsnAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitTryCatchBlock");
        super.visitTryCatchBlock(start, end, handler, type);
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitTryCatchAnnotation");
        return super.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLocalVariable");
        super.visitLocalVariable(name, desc, signature, start, end, index);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLocalVariableAnnotation");
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitLineNumber");
        super.visitLineNumber(line, start);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        System.out.println("TimerProxyClassVisitor." + version + "#visitMaxs");
        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        System.out.println("TimerProxyClassVisitor." + version + "#visitEnd");
        super.visitEnd();
    }
}
