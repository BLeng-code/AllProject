package com.lengbo.image.imageloader;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.lengbo.image.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.net.URL;

public class ImageLoaderActivity extends AppCompatActivity {

    private ImageView mImage;
    private String mUrl = "https://cn.bing.com/th?id=OIP.Q8EZ0YIZoZlFyCKtUbzyfQHaKt&pid=Api&rs=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        mImage = findViewById(R.id.image);
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(configuration);
        imageLoader.displayImage(mUrl, mImage);

    }
}
