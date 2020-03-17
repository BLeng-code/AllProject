package com.lengbo.image.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.lengbo.image.R;
import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {
    private ImageView mImage;
    private String mUrl = "https://cn.bing.com/th?id=OIP.Q8EZ0YIZoZlFyCKtUbzyfQHaKt&pid=Api&rs=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        mImage = findViewById(R.id.image);
        Picasso.get().load(mUrl).into(mImage);
    }
}
