package com.vothanhhai.apptonghopgiuaki.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vothanhhai.apptonghopgiuaki.DetailsActivity;
import com.vothanhhai.apptonghopgiuaki.R;
import com.vothanhhai.apptonghopgiuaki.model.MenuFood;

import java.util.List;

public class MenuFoodAdapter extends RecyclerView.Adapter<MenuFoodAdapter.MenuFoodViewHolder> {

    Context context;
    List<MenuFood> menuFoodList;

    public MenuFoodAdapter(Context context, List<MenuFood> menuFoodList) {
        this.context = context;
        this.menuFoodList = menuFoodList;
    }

    @NonNull
    @Override
    public MenuFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.menu_food_row_item,parent,false);
        return new MenuFoodViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return menuFoodList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MenuFoodViewHolder holder, int position) {

        holder.foodImage.setImageResource(menuFoodList.get(position).getImageURL());
        holder.name.setText(menuFoodList.get(position).getName());
        holder.price.setText(menuFoodList.get(position).getPrice());
        holder.rating.setText(menuFoodList.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailsActivity.class);
                context.startActivity(i);
            }
        });
    }



    public static final class MenuFoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView price;
        TextView name;
        TextView rating;

        public MenuFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.image_food_item);
            price = itemView.findViewById(R.id.tv_price);
            name = itemView.findViewById(R.id.tv_name_food);
            rating = itemView.findViewById(R.id.tv_rating);


        }
    }

}
