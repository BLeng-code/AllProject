package com.lengbo.image.fresco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lengbo.image.R;

public class FrescoActivity extends AppCompatActivity {
    private SimpleDraweeView mImage;
    private String mUrl = "https://cn.bing.com/th?id=OIP.Q8EZ0YIZoZlFyCKtUbzyfQHaKt&pid=Api&rs=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_fresco);
        mImage = findViewById(R.id.image);
        mImage.setImageURI(mUrl);
    }
}
