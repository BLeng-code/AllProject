package com.lengbo.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lengbo.internet.httpclient.HttpClientActivity;
import com.lengbo.internet.httpurlconnection.HttpURLConnectionActivity;
import com.lengbo.internet.okhttp.OkHttpActivity;
import com.lengbo.internet.retrofit.RetrofitActivity;
import com.lengbo.internet.volley.VolleyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, OkHttpActivity.class);
        startActivity(intent);
    }
}
