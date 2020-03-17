package com.lengbo.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.lengbo.image.fresco.FrescoActivity;
import com.lengbo.image.glide.GlideActivity;
import com.lengbo.image.imageloader.ImageLoaderActivity;
import com.lengbo.image.picasso.PicassoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, FrescoActivity.class);
        startActivity(intent);
    }
}
