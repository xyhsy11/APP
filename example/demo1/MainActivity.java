package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivityTag";
    private Button add_btn;
    private Button minus_btn;
    private TextView text_tv;
    private Button jump_btn;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        initView();
        initData();
        Log.i(TAG, "onCreate: ------------------");

    }

    private void initData() {
        mHandler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: --------------------");
                mHandler.postDelayed(this, 2996);
            }
        };
        mHandler.postDelayed(r, 2996);


    }

    private void initView() {
        add_btn = findViewById(R.id.add);
        minus_btn = findViewById(R.id.minus);
        jump_btn = findViewById(R.id.jump);
        text_tv = findViewById(R.id.res_tv);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ----------------------");
                String text = text_tv.getText().toString().trim();
                Integer text_i = Integer.parseInt(text);
                text_tv.setText("" + (++text_i));
                Log.i(TAG, "onClickText: ----------------------" + text_tv.getText().toString().trim());


            }
        });
        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ----------------------");
                String text = text_tv.getText().toString().trim();
                Integer text_i = Integer.parseInt(text);
                text_tv.setText("" + (--text_i));
                Log.i(TAG, "onClickText: ----------------------" + text_tv.getText().toString().trim());
            }
        });
        jump_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int data = Integer.parseInt(text_tv.getText().toString().trim());
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("name", "SiyuHan");
        editor.putInt("age", 16);
        editor.apply();


    }

    @Override

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ------------------");
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        String name = pref.getString("name", "");
        int age = pref.getInt("age", 0);

        Log.i(TAG, "onResume: ------------------" + name +"      "+ age);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ------------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ------------------");

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i(TAG, "onDestroy: ------------------");
    }
}
