package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.food_android.R;

public class IntroActivity extends AppCompatActivity {
Button login_btn;
Button sign_btn;
TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        login_btn = findViewById(R.id.login_btn);
        welcome = findViewById(R.id.welcome);
        sign_btn = findViewById(R.id.sign_in);

      welcome.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Animation animation= AnimationUtils.loadAnimation(IntroActivity.this,R.anim.zoomin);
              welcome.startAnimation(animation);
          }
      });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this , LoginActivity.class));
            }
        });
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this ,SignInActivity.class));
            }
        });
    }
}