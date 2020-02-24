package com.components.multidex;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Request;

import android.os.Bundle;


import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().post("fdsfsafd");
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Gson gson = new Gson();
    }
}
