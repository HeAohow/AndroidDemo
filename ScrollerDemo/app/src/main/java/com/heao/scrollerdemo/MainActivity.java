package com.heao.scrollerdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button scrollToBtn;
    private Button scrollByBtn;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        layout = (LinearLayout) findViewById(R.id.layout);
//        scrollToBtn = (Button) findViewById(R.id.scroll_to_btn);
//        scrollByBtn = (Button) findViewById(R.id.scroll_by_btn);
//
//        scrollToBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout.scrollTo(-60, -100);
//            }
//        });
//        scrollByBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout.scrollBy(-60, -100);
//            }
//        });
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
