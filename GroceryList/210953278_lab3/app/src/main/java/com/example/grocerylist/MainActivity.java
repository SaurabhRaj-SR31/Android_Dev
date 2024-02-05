package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] items = {"Apple", "Banana", "Mango", "Beer"};
    Map<String, Double> itemCostMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listV);

        // Initialize item costs
        itemCostMap = new HashMap<>();
        itemCostMap.put("Apple", 1.50); // Replace with actual costs
        itemCostMap.put("Banana", 0.75);
        itemCostMap.put("Mango", 2.00);
        itemCostMap.put("Beer", 5.00);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            double totalCost = 0.0;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items[position];
                double itemCost = itemCostMap.get(selectedItem);
                totalCost += itemCost;

                Log.d("GroceryList", "Clicked: " + selectedItem + ", Cost: $" + itemCost);
                Log.d("GroceryList", "Total Cost: $" + totalCost);

                Toast.makeText(MainActivity.this, "Clicked: " + selectedItem + ", Cost: $" + itemCost, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Total Cost: $" + totalCost, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
