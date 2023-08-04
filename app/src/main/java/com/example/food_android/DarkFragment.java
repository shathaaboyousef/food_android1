package com.example.food_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;

public class DarkFragment extends Fragment {

    private LinearLayout profileBtn;
    private LinearLayout supourtBtn;
    private LinearLayout settingsBtn;
    private LinearLayout homeBtn;
    private Switch switch2;
    private LinearLayout logout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dark, container, false);

//        profileBtn= profileBtn.findViewById(R.id.profileBtn);
//        supourtBtn= supourtBtn.findViewById(R.id.supportBtn);
//        switch2= switch2.findViewById(R.id.switch2);
//        settingsBtn= settingsBtn.findViewById(R.id.settingBtn);
//        homeBtn= homeBtn.findViewById(R.id.homeBtn);
//        logout= logout.findViewById(R.id.logout);


    }
}