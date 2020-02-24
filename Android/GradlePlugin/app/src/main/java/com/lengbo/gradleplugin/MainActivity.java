package com.lengbo.gradleplugin;


import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;

public class MainActivity extends Activity {

    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Debug.startMethodTracing();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Debug.stopMethodTracing();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
