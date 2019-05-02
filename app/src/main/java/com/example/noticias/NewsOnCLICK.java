package com.example.noticias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsOnCLICK extends AppCompatActivity {

    public static final String URL_POST = "url_post";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_on_click);

        String urlPost= getIntent().getStringExtra(URL_POST);

        webView = findViewById(R.id.webview);

        webView.loadUrl(urlPost);

    }
}
