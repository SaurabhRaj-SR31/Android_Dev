package com.example.lab_31;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List view
        ListView listView = findViewById(R.id.listView);
        String[] listItems = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(listAdapter);

        // Grid view
        GridView gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        gridView.setAdapter(gridAdapter);

        // Tab layout
        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("List");
        spec.setContent(R.id.tab1);
        spec.setIndicator("List");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Grid");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Grid");
        tabHost.addTab(spec);

        // Table layout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        for (int i = 0; i < 5; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j = 0; j < 3; j++) {
                // Create a TextView for each cell
                // You can customize this part based on your requirements
                String cellText = "Row " + (i + 1) + ", Col " + (j + 1);
                CustomTextView textView = new CustomTextView(this);
                textView.setText(cellText);
                tableRow.addView(textView);
            }

            // Add the TableRow to the TableLayout
            tableLayout.addView(tableRow);
        }
    }
}
