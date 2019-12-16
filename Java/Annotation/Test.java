import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.lengbo.annotation.HelloAnnotation;
import com.lengbo.annotation.InsertAnnotation;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

@HelloAnnotation(value = "hello")
class Test {
    public static void main(final String[] args) {
        // Test test = new Test();
        // Hello hello = test.getClass().getAnnotation(Hello.class);
        // System.out.println(hello.msg());
        String className = "Hello";
        CodeBlock codeBlock = CodeBlock.builder().add("instance = new $L()", className).build();
        MethodSpec methodSpec = MethodSpec.methodBuilder("getInstance").addModifiers(Modifier.PUBLIC)
                .addStatement("return instance").returns(TypeVariableName.get(className)).build();
        TypeSpec typeSpec = TypeSpec.classBuilder(className)
                .addField(TypeVariableName.get(className), "instance", Modifier.PRIVATE).addStaticBlock(codeBlock)
                .addMethod(methodSpec).build();

        JavaFile javaFile = JavaFile.builder("com.hello", typeSpec).build();
        try {
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @InsertAnnotation
    private void insertAnnotation() {

    }
}