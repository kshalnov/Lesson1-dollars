package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Button calcButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputStr = inputEditText.getText().toString();
                // "2222" -> 2222 текст в значение
                final double dollars = parseDoubleString(inputStr);
                final double rubles = convert(dollars);
                final String resultString = String.valueOf(rubles);

                resultTextView.setText(resultString);
            }
        });
    }

    private double parseDoubleString(String inputStr) {
        try {
            return Double.parseDouble(inputStr);
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private double convert(double input) {
        final double dollars = input;
        final double currency = 30;
        final double rubles = dollars * currency;
        return rubles;
    }

    private void initViews() {
        inputEditText = findViewById(R.id.input_edit_text);
        calcButton = findViewById(R.id.result_button);
        resultTextView = findViewById(R.id.result_text_view);
    }
}