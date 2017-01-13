package com.os.operando.asynclayoutinflater.sample;

import android.os.Bundle;
import android.support.v4.view.AsyncLayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LinearLayout) findViewById(R.id.activity_main)).addView(getLayoutInflater().inflate(R.layout.activity_test_layout, null));
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(MainActivity.this);
                asyncLayoutInflater.inflate(R.layout.activity_test_layout, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    @Override
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        Log.d("onInflateFinished", "onInflateFinished");
                        ((LinearLayout) findViewById(R.id.activity_main)).addView(view);
                    }
                });
            }
        });
    }
}
