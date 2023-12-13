package com.iao.android_projects.tp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.iao.android_projects.R;
import com.iao.android_projects.tp4.Restaurant.AdapterRestaurant;
import com.iao.android_projects.tp4.Restaurant.Details_dev;
import com.iao.android_projects.tp4.Restaurant.MenuRestaurantModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRestaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);




        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<MenuRestaurantModel> menuItems = new ArrayList<>();
        List<MenuRestaurantModel> newMenu = new ArrayList<>();

        menuItems.add(new MenuRestaurantModel(1L,R.drawable.a,100,"Pizza","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.b,100,"Pizza","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.c,100,"Sandwichs","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.d,100,"couscous","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.e,100,"Tajine","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.d,100,"Couscous","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.a,100,"Sandwichs","Demander au boucher de couper la viande en morceaux. en 4, ..."));
        menuItems.add(new MenuRestaurantModel(1L,R.drawable.c,100,"Pizza","Demander au boucher de couper la viande en morceaux. en 4, ..."));

        Intent intent  = getIntent();
        if(intent != null){
            String selectedItem = intent.getStringExtra("selectedItem");
            Toast.makeText(this," ### "+selectedItem,Toast.LENGTH_LONG).show();

            newMenu = menuItems.stream()
                    .filter(item -> item.getTitle().equals(selectedItem))
                    .collect(Collectors.toList());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRestaurant(getApplicationContext(),newMenu));



    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }
*/



        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Details");
        menu.add(0,2,1,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                // Handle the click on the item with ID 1 (Details)
                Intent intent = new Intent(MenuRestaurant.this, Details_dev.class);
                intent.putExtra("name","youssef mennani");
                intent.putExtra("appName","Tp4/Menu restaurant");
                startActivity(intent);

            case 2:
                // Handle the click on the item with ID 2 (Quitter)
                finish(); // or any other action you want for Quitter
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}