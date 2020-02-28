package com.lengbo.internet.httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lengbo.internet.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnection);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.lengbo.site");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    OutputStream outputStream = connection.getOutputStream();
                    String params = "params";
                    outputStream.write(params.getBytes());


                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(inputStream);

                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String buffer = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((buffer = bufferedReader.readLine()) != null) {
                        stringBuffer.append(buffer);
                    }
                    bufferedReader.close();
                    inputStream.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();



    }
}
