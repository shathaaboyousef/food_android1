package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.food_android.R;

public class SignInActivity extends AppCompatActivity {

    private Button sign;
    private TextView logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sign = findViewById(R.id.signBtn);
        logIn = findViewById(R.id.loginTxt);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this , LoginActivity.class));
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this , LoginActivity.class));
            }
        });

    }
}