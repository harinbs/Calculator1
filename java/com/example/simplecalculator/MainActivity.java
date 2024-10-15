package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private String operator;
    private double operand1 = 0;
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

        // Number button onClick
        View.OnClickListener numberListener = v -> {
            if (isNewOp) {
                result.setText("");
                isNewOp = false;
            }
            Button button = (Button) v;
            result.append(button.getText());
        };

        // Set listeners for number buttons
        findViewById(R.id.button0).setOnClickListener(numberListener);
        findViewById(R.id.button1).setOnClickListener(numberListener);
        findViewById(R.id.button2).setOnClickListener(numberListener);
        findViewById(R.id.button3).setOnClickListener(numberListener);
        findViewById(R.id.button4).setOnClickListener(numberListener);
        findViewById(R.id.button5).setOnClickListener(numberListener);
        findViewById(R.id.button6).setOnClickListener(numberListener);
        findViewById(R.id.button7).setOnClickListener(numberListener);
        findViewById(R.id.button8).setOnClickListener(numberListener);
        findViewById(R.id.button9).setOnClickListener(numberListener);

        // Operator button onClick
        View.OnClickListener operatorListener = v -> {
            Button button = (Button) v;
            operator = button.getText().toString();
            operand1 = Double.parseDouble(result.getText().toString());
            isNewOp = true;
        };

        // Set listeners for operator buttons
        findViewById(R.id.button_plus).setOnClickListener(operatorListener);
        findViewById(R.id.button_minus).setOnClickListener(operatorListener);
        findViewById(R.id.button_multiply).setOnClickListener(operatorListener);
        findViewById(R.id.button_divide).setOnClickListener(operatorListener);

        // Equal button onClick
        findViewById(R.id.button_equal).setOnClickListener(v -> {
            double operand2 = Double.parseDouble(result.getText().toString());
            double output;
            switch (operator) {
                case "+":
                    output = operand1 + operand2;
                    break;
                case "-":
                    output = operand1 - operand2;
                    break;
                case "*":
                    output = operand1 * operand2;
                    break;
                case "/":
                    output = operand1 / operand2;
                    break;
                default:
                    output = 0;
            }
            result.setText(String.valueOf(output));
            isNewOp = true;
        });

        // Clear button onClick
        findViewById(R.id.button_clear).setOnClickListener(v -> {
            result.setText("");
            isNewOp = true;
            operand1 = 0;
            operator = null;
        });
    }
}
