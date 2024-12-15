package com.example.density_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText weightInput, lengthInput, widthInput, thicknessInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        weightInput = findViewById(R.id.weightInput);
        lengthInput = findViewById(R.id.lengthInput);
        widthInput = findViewById(R.id.widthInput);
        thicknessInput = findViewById(R.id.thicknessInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        // Set default values for demonstration
        weightInput.setText("1.69");
        lengthInput.setText("100");
        widthInput.setText("100");
        thicknessInput.setText("5");

        // Set click listener for calculate button
        calculateButton.setOnClickListener(v -> calculateDensity());
    }

    private void calculateDensity() {
        try {
            // Parse input values
            double weight = Double.parseDouble(weightInput.getText().toString());
            double length = Double.parseDouble(lengthInput.getText().toString());
            double width = Double.parseDouble(widthInput.getText().toString());
            double thickness = Double.parseDouble(thicknessInput.getText().toString());

            // Calculate density
            double density = DensityCalculator.calculateDensity(weight, length, width, thickness);

            // Display result
            String result = DensityCalculator.formatDensity(density);
            resultText.setText(result);
        } catch (NumberFormatException e) {
            // Show error if inputs are invalid
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}