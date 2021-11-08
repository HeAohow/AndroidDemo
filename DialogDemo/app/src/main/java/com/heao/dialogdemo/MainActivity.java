package com.heao.dialogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    Button mDialogBtn;
//    BottomSheetDialog mBottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDialogBtn = findViewById(R.id.dialog_btn);

//        mBottomSheetDialog = new BottomSheetDialog(this);
//        mBottomSheetDialog.setContentView(R.layout.dialog_content);
        mDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new MyDialogFragment().show(getSupportFragmentManager(), "dialog");
//                mBottomSheetDialog.show();
                MyBottomSheetDialogFragment mBDF = new MyBottomSheetDialogFragment();
                mBDF.show(getSupportFragmentManager(), mBDF.getTag());
            }
        });
    }
}