package com.lengbo.plugin

import com.android.annotations.NonNull
import com.android.build.api.transform.*
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES

class MyPlugin extends Transform implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "MyPlugin is coming";
        System.out.println(project.getExtensions())
        project.extensions.findByType(AppExtension)registerTransform(this)
    }

    @Override
    String getName() {
        return "LengBo"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    Set<QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(Context context, Collection<TransformInput> collection, Collection<TransformInput> collection1, TransformOutputProvider transformOutputProvider, boolean b) throws IOException, TransformException, InterruptedException {
        collection.each { TransformInput input ->
            input.directoryInputs.each { DirectoryInput directoryInput ->
                handleDirctory(directoryInput, transformOutputProvider)
            }
            input.jarInputs.each { JarInput jarInput ->
                handlJar(jarInput, transformOutputProvider)
            }
        }
//        super.transform(context, collection, collection1, transformOutputProvider, b);
    }

    private void handleDirctory(DirectoryInput input, TransformOutputProvider provider) {
        if (input.file.isDirectory()) {
            input.file.eachFileRecurse { File file ->
                def name = file.name;
                if (name.endsWith(".class")
                        && !name.startsWith("R\$")
                        && !"R.class".equals(name)
                        && !"BuildConfig.class".equals(name)
                        && !"android/support/v4/app/FragmentActivity.class".equals(name)) {
                    println "name is " + name;

//                    ClassReader classReader = new ClassReader(file.bytes);
//                    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
//                    ClassVisitor classVisitor = new LifeCycleVisitor(classWriter);
//                    classReader.accept(classVisitor, EXPAND_FRAMES)
//                    byte[] code = classWriter.toByteArray();
//                    FileOutputStream out = new FileOutputStream(
//                            file.parentFile.getAbsolutePath() + File.separator + name
//                    )
//                    out.write(code)
//                    out.close()

                    ClassReader classReader = new ClassReader(file.bytes)
                    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
//                    ClassVisitor cv = new LifeCycleVisitor(classWriter)
//                    classReader.accept(cv, EXPAND_FRAMES)
                    byte[] code = classWriter.toByteArray()
                    String classPath = file.parentFile.absolutePath + File.separator + name;
                    println(classPath)
                    FileOutputStream fos = new FileOutputStream(classPath)
                    fos.write(code)
                    fos.close()
                }
            }
        }
        //处理完输入文件之后，要把输出给下一个任务
        def dest = provider.getContentLocation(input.name,
                input.contentTypes, input.scopes,
                Format.DIRECTORY)
        FileUtils.copyDirectory(input.file, dest)
    }

    private void handlJar(JarInput input, TransformOutputProvider provider) {

    }


}