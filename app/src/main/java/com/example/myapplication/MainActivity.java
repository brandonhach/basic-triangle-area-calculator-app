package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "demo";
    EditText base;
    EditText height;

    TextView textViewSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *   editTextBase (inputs Base Val)
        *   editTextHeight (inputs Height Val)
        *   textViewSolution (Final answer from calculation)
        *   buttonCalc (Calculate area From base and height)
        *   buttonReset (Reset base and height)
        * */

        // Grab view from current layout
        base = findViewById(R.id.editTextBase);
        height = findViewById(R.id.editTextHeight);
        textViewSolution = findViewById(R.id.textViewSolution);

        // Base case: Clear everything
        findViewById(R.id.buttonReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base.setText("");
                height.setText("");
                textViewSolution.setText("");
            }
        });

        findViewById(R.id.buttonCalc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });

    }
    private void calculateArea() {

        try {
        double baseD = Double.parseDouble(base.getText().toString());
        double heightD = Double.parseDouble(height.getText().toString());
        double solution = baseD * heightD * .5;
        textViewSolution.setText("= " + String.valueOf(solution));

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Enter a valid number!", Toast.LENGTH_SHORT).show();
        }


    }
}