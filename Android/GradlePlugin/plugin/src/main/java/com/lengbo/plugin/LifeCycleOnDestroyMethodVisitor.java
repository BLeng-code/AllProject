package com.lengbo.plugin;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * date            2020-02-22
 * author          lengbo
 * description
 */
public class LifeCycleOnDestroyMethodVisitor extends MethodVisitor {

    public LifeCycleOnDestroyMethodVisitor(MethodVisitor methodVisitor){
        this(Opcodes.ASM4, methodVisitor);
    }

    public LifeCycleOnDestroyMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    @Override
    public void visitCode() {
//        mv.visitLdcInsn("TAG");
//        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
//        mv.visitInsn(Opcodes.DUP);
//        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
//        mv.visitLdcInsn("ok : ");
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
//        mv.visitVarInsn(Opcodes.ALOAD, 0);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Class", "getSimpleName", "()Ljava/lang/String;", false);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
//        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false);
//        mv.visitInsn(Opcodes.POP);
        super.visitCode();
    }
}
