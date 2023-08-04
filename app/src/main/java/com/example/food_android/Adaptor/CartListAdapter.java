package com.example.food_android.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_android.Domain.FoodDomain;
import com.example.food_android.Helper.ManagementCart;
import com.example.food_android.InterFace.ChangeNumberItemsListener;
import com.example.food_android.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHoder> {
    private ArrayList<FoodDomain> foodDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> foodDomains, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.foodDomains = foodDomains;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }


    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new ViewHoder(inflate);
    }
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHoder holder, int position) {
     holder.title.setText(foodDomains.get(position).getTitle());
     holder.feeEachItem.setText(String.valueOf(foodDomains.get(position).getFee()));
     holder.totalEachItem.setText(String.valueOf(Math.round(foodDomains.get(position).getNumberInCart()* foodDomains.get(position).getFee())*100/100));
     holder.num.setText(String.valueOf(foodDomains.get(position).getNumberInCart()));

     int drawableRecourceId =holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableRecourceId).into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             managementCart.plusNumberFood(foodDomains, position, new ChangeNumberItemsListener() {
                 @Override
                 public void changed() {
                     notifyDataSetChanged();
                     changeNumberItemsListener.changed();
                 }
             });
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberFood(foodDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem,num;
        ConstraintLayout constCart;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic= itemView.findViewById(R.id.picCart);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
           num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minusItem = itemView.findViewById(R.id.miunsCartBtn);
            constCart = itemView.findViewById(R.id.constCart);
        }
    }
}
