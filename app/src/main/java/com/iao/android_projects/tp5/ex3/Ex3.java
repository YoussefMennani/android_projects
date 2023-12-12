package com.iao.android_projects.tp5.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.iao.android_projects.R;

public class Ex3 extends AppCompatActivity {

    Button smsBtn, webBtn, appelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        smsBtn = findViewById(R.id.sms);
        webBtn= findViewById(R.id.web);
        appelBtn = findViewById(R.id.appel);

        smsBtn.setOnClickListener(v -> {
            Toast.makeText(this, "SMS Button Clicked", Toast.LENGTH_SHORT).show();

            // Intent to send SMS
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:063433344"));
            smsIntent.putExtra("sms_body", "Hello, this is a test SMS!");
            startActivity(smsIntent);
        });

        webBtn.setOnClickListener(v->{
            Toast.makeText(this," web Button Click",Toast.LENGTH_SHORT).show();


            // Intent to open a web page
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            startActivity(webIntent);
        });

        appelBtn.setOnClickListener(v->{
            Toast.makeText(this," Appel Button Click",Toast.LENGTH_SHORT).show();

            // Intent to dial a phone number
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:"+"0643432333"));
            startActivity(dialIntent);
        });
    }

}