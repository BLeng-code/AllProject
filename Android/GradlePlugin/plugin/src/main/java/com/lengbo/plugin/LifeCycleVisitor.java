package com.lengbo.plugin;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


/**
 * date            2020-02-22
 * author          lengbo
 * description
 */
public class LifeCycleVisitor extends ClassVisitor {

    private String className;


    public LifeCycleVisitor(ClassVisitor visitor) {
        this(Opcodes.ASM5, visitor);
    }


    public LifeCycleVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        className = name;
        System.out.println("开始处理" + className);
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("开始处理方法" + name);
        MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if ("android/support/v4/app/FragmentActivity".equals(this.className)) {
//            if ("onCreate".equals(name) ) {
//                //处理onCreate
//                return new LifeCycleOnCreateMethodVisitor(methodVisitor);
//            } else if ("onDestroy".equals(name)) {
//                //处理onDestroy
//                return new LifeCycleOnDestroyMethodVisitor(methodVisitor);
//            }
        }

        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        System.out.println("结束处理" + className);
        super.visitEnd();
    }
}
