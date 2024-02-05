package com.example.lab_43;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by their IDs
        Button btnMarshmallow = findViewById(R.id.btnMarshmallow);
        Button btnNougat = findViewById(R.id.btnNougat);
        Button btnOreo = findViewById(R.id.btnOreo);
        Button btnPie = findViewById(R.id.btnPie);

        // Set click listeners for each button
        btnMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAndroidVersionToast("Marshmallow", R.drawable.marshmellow);
            }
        });

        btnNougat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAndroidVersionToast("Nougat", R.drawable.nougat);
            }
        });

        btnOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAndroidVersionToast("Oreo", R.drawable.oreo);
            }
        });

        btnPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAndroidVersionToast("Pie", R.drawable.pie);
            }
        });
    }

    private void showAndroidVersionToast(String versionName, int versionIcon) {
        try {
            // Create a toast message with version name
            Toast toast = Toast.makeText(this, versionName, Toast.LENGTH_SHORT);

            // Set a custom view for the toast
            View view = getLayoutInflater().inflate(R.layout.custom_toast, null);

            // Set the background resource for the custom view
            view.setBackgroundResource(versionIcon);

            // Find the TextView and set the version name
            TextView textView = view.findViewById(R.id.textVersionName);
            textView.setText(versionName);

            // Set the custom view for the toast
            toast.setView(view);

            // Show the toast
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error displaying toast", Toast.LENGTH_SHORT).show();
        }
    }



}
