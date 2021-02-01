package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;




public class SecondActivity extends AppCompatActivity {
    private TextView res;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        getdata();

    }

    private void initView() {
        res = findViewById(R.id.res_tv);


    }

    private void getdata() {
        Intent intent = getIntent();
        int data = intent.getIntExtra("extra_data",0);
        res.setText(""+data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivityTag", "onStart: --------------SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivityTag", "onResume: --------------SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivityTag", "onPause: ------------------SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivityTag", "onStop: ------------------SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivityTag", "onDestroy: ------------------SecondActivity");
    }

}
