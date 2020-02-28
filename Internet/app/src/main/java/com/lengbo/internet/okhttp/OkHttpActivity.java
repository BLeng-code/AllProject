package com.lengbo.internet.okhttp;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lengbo.internet.R;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OkHttpActivity extends AppCompatActivity {
    private String TAG = "LengBo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        OkHttpClient client = new OkHttpClient.Builder()
//                                .addInterceptor(new Interceptor() {
//                                    @Override
//                                    public Response intercept(Chain chain) throws IOException {
//                                        Log.i(TAG, "第一个拦截器开始处理");
//                                        Response response = chain.proceed(chain.request());
//                                        Log.i(TAG, "第一个拦截器处理完毕");
//                                        return response;
//                                    }
//                                })
//                                .addInterceptor(new Interceptor() {
//                                    @Override
//                                    public Response intercept(Chain chain) throws IOException {
//                                        Log.i(TAG, "第二个拦截器开始处理");
//                                        Response response = chain.proceed(chain.request());
//                                        Log.i(TAG, "第二个拦截器处理完毕");
//                                        return response;
//                                    }
//                                })
                                .build();

                        Request request = new Request.Builder()
                                .url("http://www.lengbo.site")
                                .build();
                        Call call = client.newCall(request);

                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.i(TAG, "失败了");
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Log.i(TAG, "成功了");
                            }
                        });

                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });


    }
}
