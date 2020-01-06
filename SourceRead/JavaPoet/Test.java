import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        // String a = "A";
        // CodeBlock codeBlock = CodeBlock.builder()
        // .add("$T a = new $S", TypeName.INT, a)
        // .build();
        
        
        // System.out.println(codeBlock.toString());
        // System.out.println(a.toString());
        
        
        
        
        
        
        
        
        
        
        
        
        // FieldSpec fieldSpec = FieldSpec.builder(int.class, "b", Modifier.PRIVATE).build();
        // ParameterSpec parameterSpec = ParameterSpec.builder(long.class, "b").addModifiers(Modifier.FINAL).build();
        // MethodSpec methodSpec = MethodSpec.methodBuilder("a").addParameter(parameterSpec).returns(TypeName.VOID)
        //         .addStatement("int a = $N", parameterSpec).build();
        // MethodSpec methodSpec2 = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).build();
        // String className = "Test";
        // String packageName = "com.lengbo.test";
        // TypeSpec typeSpec = TypeSpec.classBuilder(className).addField(fieldSpec).addStaticBlock(codeBlock)
        //         .addMethod(methodSpec2).addMethod(methodSpec).build();
        // JavaFile javaFile = JavaFile.builder(packageName, typeSpec).indent("    ").build();
        // try {
        //     javaFile.writeTo(System.out);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }
}