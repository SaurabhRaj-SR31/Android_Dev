package com.example.lab_41;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String versions[] = {"marshmellow", "nougat", "oreo", "pie"};
    int icons[] = {R.drawable.marshmellow, R.drawable.nougat, R.drawable.oreo, R.drawable.pie};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.customListView);

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), versions, icons);
        listView.setAdapter(customBaseAdapter);

        // Set item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Display a Toast with the clicked version
                String selectedVersion = versions[position];
                Log.d("version", "Clicked: " + selectedVersion);
                Toast.makeText(getApplicationContext(), "Clicked: " + selectedVersion, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
