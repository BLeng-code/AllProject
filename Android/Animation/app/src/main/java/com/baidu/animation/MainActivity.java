package com.baidu.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        target = findViewById(R.id.target);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
//        animation = new AlphaAnimation(0, a);
//        animation = new TranslateAnimation(0,100,0,-110);
//        animation.setDuration(2000);
//        target.startAnimation(animation);
//        ObjectAnimator animator = ObjectAnimator.ofInt(target,"textColor", Color.RED, Color.BLACK );
//        animator.setDuration(10000);
//        animator.start();
//        target.setBackground(getDrawable(R.drawable.animator));
//        AnimationDrawable drawable = (AnimationDrawable) target.getBackground();
//        drawable.start();
//        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.vector_line_object);
//        animator.setTarget(target);
//        animator.start();
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) target.getDrawable();
        drawable.start();

    }
}
