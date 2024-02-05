package com.example.lab_32;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array of grocery items
        String[] groceryItems = {"Apple", "Banana", "Milk", "Bread", "Eggs", "Cheese", "Tomato", "Potato"};

        // Create an ArrayAdapter to convert the array into a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groceryItems);

        // Find the ListView and set the adapter
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Log to check if the method is triggered


                // Get the selected item
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display a toast with the selected item
                Toast.makeText(MainActivity.this, "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
