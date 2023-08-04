package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.food_android.DarkFragment;
import com.example.food_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingsActivity extends AppCompatActivity {
    private LinearLayout profileBtn;
    private LinearLayout supourtBtn;
    private LinearLayout settingsBtn;
    private LinearLayout homeBtn;
    private Switch switch2;
    private LinearLayout logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        profileBtn= findViewById(R.id.profileBtn);
        supourtBtn= findViewById(R.id.supportBtn);
        switch2= findViewById(R.id.switch2);
        settingsBtn= findViewById(R.id.settingBtn);
        homeBtn= findViewById(R.id.homeBtn);
        logout= findViewById(R.id.logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,LoginActivity.class));
            }
        });
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContaner,new DarkFragment()).commit();
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this , ProfileActivity.class));
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this , SettingsActivity.class));
            }
        });

        supourtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this , SuportActivity.class));
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
                startActivity(new Intent(SettingsActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,MainActivity.class));
            }
        });
    }
}