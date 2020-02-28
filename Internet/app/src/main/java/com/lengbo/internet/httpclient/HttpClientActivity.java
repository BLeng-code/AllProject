package com.lengbo.internet.httpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lengbo.internet.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.io.IOException;


public class HttpClientActivity extends AppCompatActivity {

    private String TAG = "LengBo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpParams params = new BasicHttpParams();
                params.setParameter("key", "value");
                HttpGet get = new HttpGet("https://www.baidu.com");
                get.setParams(params);
                try {
                    HttpResponse response = client.execute(get);
                    Log.i(TAG, response.getStatusLine().getStatusCode() + "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread internet = new Thread(runnable);
        internet.start();



    }
}
