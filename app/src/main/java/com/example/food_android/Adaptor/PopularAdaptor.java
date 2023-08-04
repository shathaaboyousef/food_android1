package com.example.food_android.Adaptor;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_android.Activity.ShowDetailsActivity;
import com.example.food_android.Domain.FoodDomain;
import com.example.food_android.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
ArrayList<FoodDomain> popularFood;


    public PopularAdaptor(ArrayList<FoodDomain> popularFood) {
        this.popularFood = popularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull PopularAdaptor.ViewHolder holder, int position) {
    holder.title.setText(popularFood.get(position).getTitle());
    holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));


    int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
                intent.putExtra("object", popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee,addBtn;
        ImageView pic;
//      ConstraintLayout mineLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);
//            mineLayout=itemView.findViewById(R.id.mineLayout);


        }
    }
}
