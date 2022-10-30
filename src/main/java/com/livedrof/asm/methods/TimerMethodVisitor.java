package com.livedrof.asm.methods;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 * 线程创建需要多长时间?
 * new 需要占用哪些资源0
 * 同时听够了有关日本企业成功经营的艺
 * 术等各种说法，也在努力寻找着适合于本国企业发展振兴的法宝。Thomas J．Peters和 Robert H．Waterman，
 * 这两位斯坦福大学的管理硕士、长期服务于美国著名的麦肯锡管理顾问公司的学者，访问了美国历史悠久、
 * 最优秀的 62 家大公司，又以获利能力和成长的速度为准则，挑出了 43 家杰出的模范公司，其中包括IBM、
 * 德州仪器、惠普、麦当劳、柯达、杜邦等各行业中的翘楚。他们对这些企业进行了深入调查、并与商学院
 * 的教授进行讨论，以麦肯锡顾问公司研究中心设计的企业组织七要素（简称 7S模型）为研究的框架，总结
 * 了这些成功企业的一些共同特点，写出了《追求卓越——美国企业成功的秘诀》一书，使众多的美国企业
 * 重新找回了失落的信心。
 * 7-S 模型指出了企业在发展过程中必须全面地考虑各方面的情况，包括结构(Structure)、制度(Systems)、风
 * 格(Style)、员工(Staff)、技能(Skills)、战略(Strategy)、共同价值观(Shared Valueds)。也就是说，企业仅具有
 * 明确的战略和深思熟虑的行动计划是远远不够的，因为企业还可能会在战略执行过程中失误。因此，战略
 * 只是其中的一个要素。
 */
public class TimerMethodVisitor extends MethodVisitor {
    public TimerMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
//        mv.visitCode();

    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
//        mv.visitMethodInsn(INVOKESTATIC, "com/livedrof/asm/methods/E", "m", "()J", false);
    }

    @Override
    public void visitInsn(int opcode) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        System.out.println("maxStack:" + maxStack + " maxLocals:" + maxLocals);
        super.visitMaxs(maxStack + 3, maxLocals);
    }
}
