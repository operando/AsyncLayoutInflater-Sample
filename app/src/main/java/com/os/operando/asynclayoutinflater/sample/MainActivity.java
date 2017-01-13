package com.os.operando.asynclayoutinflater.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.AsyncLayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.os.operando.asynclayoutinflater.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.asyncAppCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(MainActivity.this);
                asyncLayoutInflater.inflate(R.layout.view_app_compat, binding.rootGroupView, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    @Override
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        parent.addView(view);
                    }
                });
            }
        });

        binding.syncFatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.rootGroupView.addView(getLayoutInflater().inflate(R.layout.view_fat_view, null));
            }
        });

        binding.syncAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // public View inflate(XmlPullParser parser, @Nullable ViewGroup root) {
                //    return inflate(parser, root, root != null);
                // }
                // 描画される
//                getLayoutInflater().inflate(R.layout.view_sample_test, binding.rootGroupView);
                // 描画されない
                getLayoutInflater().inflate(R.layout.view_sample_test, binding.rootGroupView, false);
            }
        });

        binding.async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(MainActivity.this);
                asyncLayoutInflater.inflate(R.layout.view_sample_test, binding.rootGroupView, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    @Override
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        parent.addView(view);
                    }
                });
            }
        });

        binding.asyncFatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(MainActivity.this);
                asyncLayoutInflater.inflate(R.layout.view_fat_view, binding.rootGroupView, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    @Override
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        parent.addView(view);
                    }
                });
            }
        });

        binding.asyncMerge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(MainActivity.this);
                asyncLayoutInflater.inflate(R.layout.view_merge_test, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    @Override
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        binding.rootGroupView.addView(view);
                    }
                });
            }
        });
    }
}
