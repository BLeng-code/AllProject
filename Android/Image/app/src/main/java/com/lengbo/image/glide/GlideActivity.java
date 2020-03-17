package com.lengbo.image.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lengbo.image.R;
import com.squareup.picasso.Picasso;

public class GlideActivity extends AppCompatActivity {

    private ImageView mImage;
    private String mUrl = "https://cn.bing.com/th?id=OIP.Q8EZ0YIZoZlFyCKtUbzyfQHaKt&pid=Api&rs=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        mImage = findViewById(R.id.image);
        Glide.with(this).load(mUrl).into(mImage);
    }
}
