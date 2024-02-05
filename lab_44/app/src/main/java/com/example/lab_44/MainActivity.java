package com.example.lab_44;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButtonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButtonProfile = findViewById(R.id.toggleButtonProfile);
        Button buttonAction = findViewById(R.id.buttonAction);

        // Set click listener for the "Action" button
        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the state of the ToggleButton
                toggleButtonProfile.toggle();
            }
        });

        // Set listener for changes in ToggleButton state
        toggleButtonProfile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Display a toast message based on the new state
                if (isChecked) {
                    showToast("Current Profile: Ringing");
                } else {
                    showToast("Current Profile: Silent");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
