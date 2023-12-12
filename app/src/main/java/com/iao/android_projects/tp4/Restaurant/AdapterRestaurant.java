package com.iao.android_projects.tp4.Restaurant;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iao.android_projects.R;

import java.util.List;

public class AdapterRestaurant extends RecyclerView.Adapter<RestaurantViewHolder> {

    Context context;
    List<MenuRestaurantModel> menuItems;

    public AdapterRestaurant(Context context,List<MenuRestaurantModel> menuItems){
        this.context = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant_layout, parent, false));
        viewHolder.setOnItemClickListener(new RestaurantViewHolder.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                // Handle item click here

                // You can now use the 'title' variable as needed
                String title = menuItems.get(position).getTitle();
                showToast("Clicked: " + title);
                Log.d("selcted","hello");
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.prix.setText(String.valueOf(menuItems.get(position).getPrix()));
        holder.title.setText(menuItems.get(position).getTitle());
        holder.description.setText(String.valueOf(menuItems.get(position).getDescription()));
        holder.imageView.setImageResource(menuItems.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
