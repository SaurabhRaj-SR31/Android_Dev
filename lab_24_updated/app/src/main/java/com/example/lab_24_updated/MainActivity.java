package com.example.lab_24_updated;



import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button goButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        goButton = findViewById(R.id.goButton);
        webView = findViewById(R.id.webView);
    }

    public void openWebPage(View view) {
        String url = urlEditText.getText().toString();
        if (!url.isEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                // If URL doesn't start with "http://" or "https://", add "http://"
                url = "http://" + url;
            }
            webView.loadUrl(url);
        }
    }
}
