package com.example.calulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder currentInput;
    private double operand1;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        currentInput = new StringBuilder();

        GridLayout buttonsGridLayout = findViewById(R.id.buttonsGridLayout);
        setButtonClickListeners(buttonsGridLayout);
    }

    private void setButtonClickListeners(GridLayout gridLayout) {
        int childCount = gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = gridLayout.getChildAt(i);
            if (childView instanceof Button) {
                Button button = (Button) childView;
                button.setOnClickListener(v -> onButtonClick(button.getText().toString()));
            }
        }
    }

    private void onButtonClick(String buttonText) {
        switch (buttonText) {
            case "Back":
                handleBackButtonClick();
                break;
            case "=":
                handleEqualsButtonClick();
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                handleOperatorButtonClick(buttonText);
                break;
            default:
                handleDigitButtonClick(buttonText);
                break;
        }
    }

    private void handleBackButtonClick() {
        if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
        }
        updateResultText();
    }

    private void handleEqualsButtonClick() {
        if (operand1 != 0 && currentInput.length() > 0) {
            double operand2 = Double.parseDouble(currentInput.toString());
            double result = performOperation(operand1, operand2, operator);
            displayResult(operand1, operator, operand2, result);
            clearInput();
        }
    }

    private void handleOperatorButtonClick(String newOperator) {
        if (currentInput.length() > 0) {
            if (operand1 == 0) {
                operand1 = Double.parseDouble(currentInput.toString());
                operator = newOperator;
                clearInput();
            } else {
                handleEqualsButtonClick();
                operator = newOperator;
            }
        }
    }

    private void handleDigitButtonClick(String digit) {
        currentInput.append(digit);
        updateResultText();
    }

    private void updateResultText() {
        resultTextView.setText(currentInput.toString());
    }

    private void clearInput() {
        currentInput.setLength(0);
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "x":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    // Handle division by zero
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }

    private void displayResult(double operand1, String operator, double operand2, double result) {
        String resultText = String.format("%.2f %s %.2f = %.2f", operand1, operator, operand2, result);
        resultTextView.setText(resultText);
    }
}
