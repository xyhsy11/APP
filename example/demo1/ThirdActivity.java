package com.example.demo1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.utils.RomUtils;
import com.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView cameraBtn;
    private ImageView recordBtn;
    private ImageView qrcodeBtn;
    private ImageView qrcodeIv;
    private TextView resTv;
    private List<String> data;
    private ListView show;
    private ArrayAdapter adapter;

    public static final String TAG = "--ThirdActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
/*
        setStatusBarFullTransparent();
*/
        setContentView(R.layout.activity_third_temp);
        initView();
        initData();
        setAdapter();
    }

    private void setAdapter() {
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        show.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("item"+i);
        }


    }

    private void initView() {
        qrcodeBtn = findViewById(R.id.qrcode_iv);
        recordBtn = findViewById(R.id.record_iv);
        cameraBtn = findViewById(R.id.camera_iv);
        qrcodeIv = findViewById(R.id.add_iv);
        resTv = findViewById(R.id.res_tv);
        cameraBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
        qrcodeBtn.setOnClickListener(this);
        qrcodeIv.setOnClickListener(this);
        show = findViewById(R.id.message_lv);


    }

    @Override
    protected void onStart() {
        RomUtils.setAndroidNativeLightStatusBar(this, true);
        super.onStart();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String result = data.getExtras().getString("result");
            resTv.setText(result);
        }

        qrcodeIv.setClickable(true);
    }

    protected void setStatusBarFullTransparent() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4


            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_iv:
                Log.i(TAG, "camera_btn");
                break;
            case R.id.record_iv:
                Log.i(TAG, "record_btn");
                break;
            case R.id.qrcode_iv:
                Log.i(TAG, "qrcode_btn");
                break;
            case R.id.add_iv:
                qrcodeIv.setClickable(false);
                startActivityForResult(new Intent(this, CaptureActivity.class),0);
                Log.i(TAG, "add_iv");

                break;

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    
}
