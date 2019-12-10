package com.baidu.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

public class A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        final Button jumpToB = findViewById(R.id.jumpToB);
        jumpToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A.this, B.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(A.this, jumpToB, "share").toBundle());
            }
        });

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        animation.setDuration(2000);
//        ViewGroup viewGroup = findViewById(R.id.container);
//        LayoutAnimationController controller = new LayoutAnimationController(animation);
//        viewGroup.setLayoutAnimation(controller);
    }
}
