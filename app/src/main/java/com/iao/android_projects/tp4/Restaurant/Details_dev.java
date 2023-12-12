package com.iao.android_projects.tp4.Restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iao.android_projects.R;
import com.iao.android_projects.tp4.MenuRestaurant;

public class Details_dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_dev);

        Intent receivedIntent = getIntent();
        if (receivedIntent.hasExtra("name")) {
            String name = receivedIntent.getStringExtra("name");
            Toast.makeText(this," dev Name :"+name,Toast.LENGTH_LONG).show();
        }

        if (receivedIntent.hasExtra("appName")) {
            String appName = receivedIntent.getStringExtra("appName");
            // Retrieve the data using getStringExtra (adjust this based on the data type)
            Toast.makeText(this," appName :"+appName,Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Menu Restaurant");
        menu.add(0,2,1,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                // Handle the click on the item with ID 1 (Details)
                Intent intent = new Intent(Details_dev.this, MenuRestaurant.class);

                startActivity(intent);


            case 2:
                // Handle the click on the item with ID 2 (Quitter)
                finish(); // or any other action you want for Quitter
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}