package com.example.demo1;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MusicActivity";
    private Button pauseBtn;
    private Button startBtn;
    private MediaPlayer player;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initView();
        initData();
        player = MediaPlayer.create(this,R.raw.prelude);
        Intent stopIntent = new Intent(this,MusicService.class);


    }

    private void initData() {
        startBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
    }

    private void initView() {
        startBtn = findViewById(R.id.start_btn);
        pauseBtn = findViewById(R.id.pause_btn);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
        Intent stopIntent = new Intent(this,MusicService.class);
        stopService(stopIntent);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_btn:
                Intent startIntent = new Intent(this,MusicService.class);
                startService(startIntent);
                break;
            case R.id.pause_btn:
                break;

        }


    }

}
