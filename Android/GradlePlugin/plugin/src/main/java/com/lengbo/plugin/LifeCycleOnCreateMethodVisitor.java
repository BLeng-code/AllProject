package com.lengbo.plugin;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * date            2020-02-22
 * author          lengbo
 * description
 */
public class LifeCycleOnCreateMethodVisitor extends MethodVisitor {

    public LifeCycleOnCreateMethodVisitor(MethodVisitor methodVisitor) {
        this(Opcodes.ASM4, methodVisitor);
    }

    public LifeCycleOnCreateMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }
}
