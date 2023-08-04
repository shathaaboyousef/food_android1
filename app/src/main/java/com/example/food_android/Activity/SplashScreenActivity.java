package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.food_android.R;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    ImageView img;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        img = findViewById(R.id.splash_img);
        img.animate().alpha(4000).setDuration(0);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(SplashScreenActivity.this,IntroActivity.class);
                startActivity(dsp);
                finish();
            }
        },4000);
    }
}