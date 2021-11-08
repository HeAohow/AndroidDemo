package com.heao.viewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private SimpleListView mListView;
    private SimpleListView.SimpleAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new ArrayList<>();
        initData();

        mListView = findViewById(R.id.simple_list_view);
        mListView.setDeleteListener(index -> {
            mData.remove(index);
            mAdapter.notifyDataSetChanged();
        });
        mAdapter = new SimpleListView.SimpleAdapter(this, 0, mData);
        mListView.setAdapter(mAdapter);

    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mData.add("Item " + i);
        }
    }
}