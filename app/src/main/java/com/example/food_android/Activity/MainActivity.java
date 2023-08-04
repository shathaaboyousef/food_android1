package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.food_android.Adaptor.CategoryAdaptor;
import com.example.food_android.Adaptor.PopularAdaptor;
import com.example.food_android.Domain.CategoryDomain;
import com.example.food_android.Domain.FoodDomain;
import com.example.food_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private RecyclerView.Adapter adapter,adapter2;
     private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
     private ImageView profilePic;
     private LinearLayout profileBtn;
     private LinearLayout supourtBtn;
     private LinearLayout settingsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          profilePic = findViewById(R.id.profilePic);
        profileBtn= findViewById(R.id.profileBtn);
        supourtBtn= findViewById(R.id.supportBtn);
       settingsBtn= findViewById(R.id.settingBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , ProfileActivity.class));
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , SettingsActivity.class));
            }
        });

        supourtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , SuportActivity.class));
            }
        });


        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , ProfileActivity.class));
            }
        });


        recyclerViewCategory();
        recyclerViewPopular();
      bottomNavigation();

        
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn1);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }
    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add( new CategoryDomain("Pizza","cat_1"));
        category.add( new CategoryDomain("Burger","cat_2"));
        category.add( new CategoryDomain("Hotdog","cat_3"));
        category.add( new CategoryDomain("Drink","cat_4"));
        category.add( new CategoryDomain("Donat","cat_5"));
        adapter= new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
}
     private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList =findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pizzash", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper,",9.76));
        foodList.add(new FoodDomain("Cheese Burger", "burgerr", "slices pepperoni, mozzerella cheese, fresh oregano, ground black peppe",8.79));
        foodList.add(new FoodDomain("Drinks", "cocacola", "slices pepperoni, mozzerella cheese, fresh oregano, ground black peppe",8.5));
        foodList.add(new FoodDomain("Hotdog", "hotdog", "slices pepperoni, mozzerella cheese, fresh oregano, ground black peppe",8.5));
        foodList.add(new FoodDomain("Donat", "donatsh", "slices pepperoni, mozzerella cheese, fresh oregano, ground black peppe",8.5));
        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
   }
}