package com.example.lab_24;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        webView = findViewById(R.id.webView);

        // Enable JavaScript (optional)
        webView.getSettings().setJavaScriptEnabled(true);

        // Set a WebViewClient to handle redirects and open links in the WebView
        webView.setWebViewClient(new WebViewClient());
    }

    // Handle the search button click
    public void onSearchButtonClick(View view) {
        String url = urlEditText.getText().toString();

        // Check if the URL is not empty
        if (!url.isEmpty()) {
            // Load the URL in the WebView
            webView.loadUrl(url);
        }
    }

    // Handle the back button press to navigate within the WebView
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
