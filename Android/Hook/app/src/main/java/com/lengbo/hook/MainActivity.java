package com.lengbo.hook;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lengbo.hook.ams.AMSActivity;

public class MainActivity extends Activity {
    private String TAG = "LengBo";

    public MainActivity() {
        super();
        Log.i(TAG, "构造函数");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.jump);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AMSActivity.class);
//                startActivity(intent);
                set();
            }
        });
    }

    private void set() {
        Log.i(TAG, "原生");
    }


}
