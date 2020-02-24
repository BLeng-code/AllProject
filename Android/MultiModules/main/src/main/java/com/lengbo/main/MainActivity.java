package com.lengbo.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lengbo.data.file.FileUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FileUtil.deal();
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.lengbo.account.MainActivity.class));
            }
        });
    }
}
