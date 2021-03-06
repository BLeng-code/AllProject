package com.lengbo.annotation;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import javax.tools.Diagnostic.Kind;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

public class MyProcessor extends AbstractProcessor {

    private Filer filer;
    private Types typeUtils;
    private Elements elementUtils;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        // TODO Auto-generated method stub
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<Element> elements = (Set<Element>) roundEnv.getElementsAnnotatedWith(SingleInstance.class);
        for (Element element : elements) {
            if (element instanceof TypeElement) {
                TypeElement typeElement = (TypeElement) element;
                PackageElement packageElement = elementUtils.getPackageOf(typeElement);
                String className = typeElement.getSimpleName().toString();
                FieldSpec fieldSpec = FieldSpec.builder(TypeVariableName.get(className), "instance", Modifier.PRIVATE)
                        .build();
                CodeBlock codeBlock = CodeBlock.builder().add("instance = new $L()", className).build();
                MethodSpec methodSpec = MethodSpec.methodBuilder("getInstance").returns(TypeVariableName.get(className))
                        .addModifiers(Modifier.PUBLIC).addStatement("return instance").build();
                TypeSpec typeSpec = TypeSpec.classBuilder(className).addMethod(methodSpec).addStaticBlock(codeBlock)
                        .addField(fieldSpec).build();
                JavaFile javaFile = JavaFile.builder(packageElement.getQualifiedName(), typeSpec);
                javaFile.writeTo(filer);
            } else {
                messager.printMessage(Kind.ERROR, "SingleInstance Just can be used above type");
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(HelloAnnotation.class.getCanonicalName());
        annotations.add(InsertAnnotation.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}