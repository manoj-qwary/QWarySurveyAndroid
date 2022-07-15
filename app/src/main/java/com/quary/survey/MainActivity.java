package com.quary.survey;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        new Survey.Builder()
                .setActivity(this)
                .setDomain("https://www.google.com/")
                .setToken("")
                .setLoader(true)
                .show();
    }
}