package com.example.webviewejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar bar;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.miweb1);
        bar = findViewById(R.id.progres1);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://e-learning.uth.hn/v2/index.php");
        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                bar.setVisibility(View.VISIBLE);
                bar.setProgress(newProgress);
                progressDialog.show();

                if(newProgress==100){
                    bar.setProgress(View.GONE);
                    setTitle(getTitle());
                    progressDialog.dismiss();
                }
            }
        });
    }
}