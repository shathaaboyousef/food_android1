package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.food_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {
    private LinearLayout profileBtn;
    private LinearLayout supourtBtn;
    private LinearLayout settingsBtn;
    private LinearLayout homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileBtn= findViewById(R.id.profileBtn);
        supourtBtn= findViewById(R.id.supportBtn);
        settingsBtn= findViewById(R.id.settingBtn);
        homeBtn= findViewById(R.id.homeBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this , ProfileActivity.class));
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this , SettingsActivity.class));
            }
        });

        supourtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this , SuportActivity.class));
            }
        });

        bottomNavigation();

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn1);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });
    }
}