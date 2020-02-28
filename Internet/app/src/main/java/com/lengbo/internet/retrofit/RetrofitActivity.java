package com.lengbo.internet.retrofit;

import androidx.appcompat.app.AppCompatActivity;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.lengbo.internet.R;

public class RetrofitActivity extends AppCompatActivity {
    private String TAG = "LengBo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
//        Retrofit retrofit =new Retrofit.Builder()
//                .baseUrl("http://www.lengbo.site")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestService requestService = retrofit.create(RequestService.class);
//        Call<Object> call = requestService.call();
//        call.enqueue(new Callback<Object>() {
//
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                Log.i(TAG, response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

    }
}
