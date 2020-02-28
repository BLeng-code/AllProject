package com.lengbo.fourcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lengbo.fourcomponents.activity.AActivity;
import com.lengbo.fourcomponents.service.AService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, AService.class);
        startService(intent);
        Intent intent1 = new Intent(MainActivity.this, AActivity.class);
        startActivity(intent1);
    }
}
