package com.iao.android_projects.tp4.travail_a_faire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.ToggleButton;

import com.iao.android_projects.R;

public class Horloge extends AppCompatActivity {


    private AnalogClock analogClock;
    private TextClock textClock;

    private Switch toggleSwitch;

    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horloge);

        analogClock = findViewById(R.id.analogClock);
        textClock = findViewById(R.id.digitalClock);
        toggleSwitch = findViewById(R.id.switch1);
        resetButton = findViewById(R.id.resetButton);

        setTitle("Horloge");

        updateClockVisibility();

        // Set a listener for the switch change events
        toggleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update the visibility of clocks based on the switch state
            updateClockVisibility();
        });

        resetButton.setOnClickListener(v -> {
            toggleSwitch.setChecked(false);
            updateClockVisibility();
        });

    }

    private void updateClockVisibility() {
        // Check the state of the switch and toggle the visibility of clocks accordingly
        if (toggleSwitch.isChecked()) {
            analogClock.setVisibility(android.view.View.VISIBLE);
            textClock.setVisibility(android.view.View.GONE);
            toggleSwitch.setText("Digital Clock");
        } else {
            analogClock.setVisibility(android.view.View.GONE);
            textClock.setVisibility(android.view.View.VISIBLE);
            toggleSwitch.setText("Numérique Clock");
        }
    }

}