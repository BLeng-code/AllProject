package com.baidu.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

//        getWindow().setEnterTransition(new Explode().setDuration(2000));
        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(2000);
//        getWindow().setReturnTransition(slide);
//        getWindow().setReturnTransition(new Slide().setDuration(5000));
//        getWindow().setReenterTransition(new Fade().setDuration(2000));

        Button jumpToA = findViewById(R.id.jumpToA);
        jumpToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(B.this, A.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(B.this).toBundle());
            }
        });
        Button jumpToC = findViewById(R.id.jumpToC);
        jumpToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(B.this, C.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(B.this).toBundle());
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAfterTransition();
    }
}
