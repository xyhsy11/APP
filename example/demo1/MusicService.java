package com.example.demo1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    public static final String TAG = "MusicService";
    private MediaPlayer player;


    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.prelude);
        Log.i(TAG, "onCreate: ----------------");
        player.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ----------------");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
        Log.i(TAG, "onDestroy: ----------------");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
