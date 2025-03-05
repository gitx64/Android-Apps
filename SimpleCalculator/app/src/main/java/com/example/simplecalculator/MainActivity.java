package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText expressionEditText;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals, buttonClear;
    TextView equationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expressionEditText = findViewById(R.id.expressionEditText);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        buttonEquals = findViewById(R.id.button_clear); // Renamed to buttonEquals to reflect its function
        buttonClear = findViewById(R.id.clear);
        equationTextView = findViewById(R.id.equationTextView); // Initialize the TextView

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("+");
                expressionEditText.setSelection(expressionEditText.length());
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("-");
                expressionEditText.setSelection(expressionEditText.length());
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("*");
                expressionEditText.setSelection(expressionEditText.length());
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("/");
                expressionEditText.setSelection(expressionEditText.length());
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
                expressionEditText.setSelection(expressionEditText.length());
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressionEditText.setText("");
                equationTextView.setText(""); // Clear the equation TextView
                expressionEditText.setSelection(expressionEditText.length());
            }
        });
    }

    private void appendToExpression(String value) {
        String currentText = expressionEditText.getText().toString();
        expressionEditText.setText(currentText + value);
    }

    private void calculateResult() {

        String expression = expressionEditText.getText().toString();
        double result = evaluateSimpleExpression(expression);
        if(Double.isNaN(result)){
            expressionEditText.setText("Error");
        }
        expressionEditText.setText(String.valueOf(result));
        equationTextView.setText(expression);
    }

    private double evaluateSimpleExpression(String expression) {

        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        } else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        } else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        } else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        } else {
            return Double.parseDouble(expression);
        }
    }
}