package com.iao.android_projects.tp3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.iao.android_projects.R;

public class Calculette_taf extends AppCompatActivity {

    private EditText valeur1, valeur2;
    private RadioGroup radioGroup;
    private Button raz, equal, quitter;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculette_taf);

        valeur1 = findViewById(R.id.valeur1);
        valeur2 = findViewById(R.id.valeur2);
        radioGroup = findViewById(R.id.radioGroup);
        raz = findViewById(R.id.raz);
        equal = findViewById(R.id.equal);
        quitter = findViewById(R.id.quitter);
        result = findViewById(R.id.result);

        raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateResult() {
        try {
            double value1 = Double.parseDouble(valeur1.getText().toString());
            Log.d("param", "calculateResult: "+value1);
            double value2 = Double.parseDouble(valeur2.getText().toString());
            Log.d("param", "calculateResult: "+value2);

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            String operator = selectedRadioButton.getText().toString();

            Log.d("operator", operator);


            double resultValue = 0;

            switch (operator) {
                case "plus":
                    Log.d("switch case", "plus");
                    resultValue = value1 + value2;
                    break;
                case "moins":
                    Log.d("switch case", "moins");
                    resultValue = value1 - value2;
                    break;
                case "multiplié":
                    Log.d("switch case", "multiplié");
                    resultValue = value1 * value2;
                    break;
                case "divisé":
                    Log.d("switch case", "divisé");
                    if (value2 != 0) {
                        resultValue = value1 / value2;
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            result.setText("Résultat: " + resultValue);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInputs() {
        valeur1.getText().clear();
        valeur2.getText().clear();
        radioGroup.clearCheck();
        result.setText("Résultat");
    }
}
