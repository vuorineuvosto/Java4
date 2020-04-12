package com.example.netti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    EditText url;
    int count = 1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        url = findViewById(R.id.url);
        webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/index.html");


    }

    public void openUrl(View a){
        String address = url.getText().toString();
        webview.loadUrl("http://" + address);
    }
    public void goBack(View a){
        if (webview.canGoBack()){
            webview.goBack();
        }
    }
    public void goForward(View a){
        if (webview.canGoForward()){
            webview.goForward();
        }
    }
    public void refresh(View a){
        webview.reload();
    }
    public void executeJavaScript(View b){

            if (count % 2 == 0) {
                webview.evaluateJavascript("javascript:initialize()", null);
            } else {
                webview.evaluateJavascript("javascript:shoutOut()", null);
            }
            count++;
    }



    }


