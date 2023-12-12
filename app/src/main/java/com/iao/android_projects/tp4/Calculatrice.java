package com.iao.android_projects.tp4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.iao.android_projects.R;

public class Calculatrice extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private String operand = "";
    private double num1 = 0;
    private double num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        resultTextView = findViewById(R.id.resultTextView);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View child = gridLayout.getChildAt(i);

            if (child instanceof Button) {
                final Button button = (Button) child;

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleButtonClick(button.getText().toString());
                    }
                });
            }
        }
    }

    private void handleButtonClick(String buttonText) {
        if (buttonText.matches("[0-9]+") || buttonText.equals(".")) {
            currentNumber += buttonText;
            updateResultTextView();
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            if (!currentNumber.isEmpty()) {
                num1 = Double.parseDouble(currentNumber);
                operand = buttonText;
                currentNumber = "";
            }
        } else if (buttonText.equals("=")) {
            if (!currentNumber.isEmpty()) {
                num2 = Double.parseDouble(currentNumber);
                calculateResult();
            }
        }
        else if (buttonText.equals("C")) {
            resultTextView.setText("");
            operand="";
        }
    }

    private void calculateResult() {
        double result = 0;

        switch (operand) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
        }

        currentNumber = String.valueOf(result);
        updateResultTextView();
        num1 = result;
        operand = "";
        num2 = 0;
    }

    private void updateResultTextView() {
        resultTextView.setText(currentNumber);
    }
}
