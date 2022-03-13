package com.example.madmeditation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.madmeditation.common.BasicActivity;
import com.example.madmeditation.databinding.ActivityMainBinding;
import com.example.madmeditation.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends BasicActivity {

    ActivityOnBoardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        ImageView image = binding.imageView;
        //<alpha xmlns:android="http://schemas.android.com/apk/res/android"
        //        android:interpolator="@interpolator/decelerate_quad"
        //        android:fromAlpha="0.0" android:toAlpha="1.0"
        //        android:duration="@android:integer/config_longAnimTime" />
        //Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        //Animation fade = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale_in);
        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Animation custom = AnimationUtils.loadAnimation(this, R.anim.custom);
        binding.imageView.startAnimation(fade);
        binding.hello.startAnimation(scale);
        binding.introduce.startAnimation(translate);
        binding.button.startAnimation(rotate);
        binding.tvRegist.startAnimation(custom);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(OnBoardingActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        }, 3000l);*/


    }
}