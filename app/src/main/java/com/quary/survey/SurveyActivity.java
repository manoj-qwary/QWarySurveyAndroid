package com.quary.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class SurveyActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar mProg;

    private String domain;
    private String token;
    private Boolean loader;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.domain = extras.getString("domain");
            this.token = extras.getString("token");
            this.loader = extras.getBoolean("loader");
            //The key argument here must match that used in the other activity
        }

        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

        if (loader) {
            mProg = new ProgressBar(getApplicationContext());
            mProg.setLayoutParams(lp);
        }


        webView = new WebView(getApplicationContext());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadUrl(this.domain + this.token);
//        webView.loadUrl("https://survey.qwary.com/form/S_wSzSPnasH9Wc_FT15X0J1BuEcPl5gIZ99rQiotQa8");

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                if (loader) {
                    mProg.setVisibility(View.GONE);
                }
            }
        });

        setContentView(relativeLayout, rlp);

    }
}