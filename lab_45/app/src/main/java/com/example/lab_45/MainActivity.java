package com.example.lab_45;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxPizza;
    private CheckBox checkBoxBurger;
    private CheckBox checkBoxPasta;
    private CheckBox checkBoxSalad;
    private CheckBox checkBoxBiryani;
    private CheckBox checkBoxTandooriChicken;

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxPizza = findViewById(R.id.checkBoxPizza);
        checkBoxBurger = findViewById(R.id.checkBoxBurger);
        checkBoxPasta = findViewById(R.id.checkBoxPasta);
        checkBoxSalad = findViewById(R.id.checkBoxSalad);
        checkBoxBiryani = findViewById(R.id.checkBoxBiryani);
        checkBoxTandooriChicken = findViewById(R.id.checkBoxTandooriChicken);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display ordered items and total cost in a Toast
                displayOrder();

                // Delay disabling the checkboxes for a short time
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Disable all checkboxes after submitting the order
                        setCheckBoxesEnabled(false);
                    }
                }, 100);
            }
        });

    }

    private void setCheckBoxesEnabled(boolean enabled) {
        checkBoxPizza.setEnabled(enabled);
        checkBoxBurger.setEnabled(enabled);
        checkBoxPasta.setEnabled(enabled);
        checkBoxSalad.setEnabled(enabled);
        checkBoxBiryani.setEnabled(enabled);
        checkBoxTandooriChicken.setEnabled(enabled);
    }

    private void displayOrder() {
        StringBuilder orderDetails = new StringBuilder("Ordered Items:\n");

        // Calculate and display cost for each item
        if (checkBoxPizza.isChecked()) {
            orderDetails.append("Pizza - Rs.200\n");
        }
        if (checkBoxBurger.isChecked()) {
            orderDetails.append("Burger - Rs.100\n");
        }
        if (checkBoxPasta.isChecked()) {
            orderDetails.append("Pasta - Rs.150\n");
        }
        if (checkBoxSalad.isChecked()) {
            orderDetails.append("Salad - Rs.70\n");
        }
        if (checkBoxBiryani.isChecked()) {
            orderDetails.append("Biryani - Rs.250\n");
        }
        if (checkBoxTandooriChicken.isChecked()) {
            orderDetails.append("Tandoori Chicken - Rs.270\n");
        }

        // Calculate and display total cost
        double totalCost = calculateTotalCost();
        orderDetails.append("\nTotal Cost: Rs.").append(totalCost);

        // Show the order details in a Toast
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, orderDetails.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private double calculateTotalCost() {
        double totalCost = 0.0;

        if (checkBoxPizza.isChecked()) {
            totalCost += 200.0;
        }
        if (checkBoxBurger.isChecked()) {
            totalCost += 100.0;
        }
        if (checkBoxPasta.isChecked()) {
            totalCost += 150.0;
        }
        if (checkBoxSalad.isChecked()) {
            totalCost += 70.0;
        }
        if (checkBoxBiryani.isChecked()) {
            totalCost += 250.0;
        }
        if (checkBoxTandooriChicken.isChecked()) {
            totalCost += 270.0;
        }

        return totalCost;
    }
}
