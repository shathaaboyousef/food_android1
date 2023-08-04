package com.example.food_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_android.Domain.FoodDomain;
import com.example.food_android.Helper.ManagementCart;
import com.example.food_android.R;

public class ShowDetailsActivity extends AppCompatActivity {
 private TextView addToCartBtn,titleText,feeText,desceptionTxt,numberOrderTxt;
 private ImageView pulsBtn,minusBtn,picFood;
 private FoodDomain object;
 int numberOrder=1;
 private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

       managementCart=new ManagementCart(this);
       initView();
       getBlundle();
        
    }

    private void getBlundle() {
        object=(FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);

        titleText.setText(object.getTitle());
        feeText.setText("$"+ object.getFee());
        desceptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        pulsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });


        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder > 1){
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleText = findViewById(R.id.titleTxt);
       feeText = findViewById(R.id.priceTxt);
        desceptionTxt = findViewById(R.id.descraptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderText);
        pulsBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minsBtn);
        picFood = findViewById(R.id.picfood);
    }
}