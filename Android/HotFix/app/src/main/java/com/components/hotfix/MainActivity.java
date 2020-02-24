package com.components.hotfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sayHello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                cat.sayHello(MainActivity.this);
            }
        });
    }
}
