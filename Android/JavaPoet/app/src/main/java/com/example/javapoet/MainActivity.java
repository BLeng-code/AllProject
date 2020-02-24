package com.example.javapoet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CodeBlock codeBlock = CodeBlock.builder()
                .add("$T a;", TypeName.INT)
                .addStatement("$L a", String.class)
                .build();
        codeBlock.toString();

        MethodSpec methodSpec = MethodSpec.methodBuilder("a")
                .addComment(" comment" )
                .build();
        methodSpec.toString();
        TypeSpec typeSpec = TypeSpec.classBuilder("Test")
                .addStaticBlock(codeBlock)
                .build();
        typeSpec.toString();
        setContentView(R.layout.activity_main);
    }
}
