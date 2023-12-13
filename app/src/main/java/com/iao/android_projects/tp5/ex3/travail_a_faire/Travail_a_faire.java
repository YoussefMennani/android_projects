package com.iao.android_projects.tp5.ex3.travail_a_faire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.iao.android_projects.R;
import com.iao.android_projects.tp4.MenuRestaurant;

public class Travail_a_faire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travail_afaire);

        String[] productTitles = {"Pizza","Sandwichs","Couscous", "Salades", "Desserts", "Boissons","Tajine"};

        ListView listView = findViewById(R.id.productListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.restaurant_item_layout,
                R.id.restaurantItemText,
                productTitles
            );

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent mealsListIntent = new Intent(Travail_a_faire.this, MenuRestaurant.class);
                //Toast.makeText(getApplicationContext(), "Selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
                mealsListIntent.putExtra("selectedItem",selectedItem);
                startActivity(mealsListIntent);
            }
        });
    }


}