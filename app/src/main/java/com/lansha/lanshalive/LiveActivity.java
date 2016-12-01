package com.lansha.lanshalive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class LiveActivity extends AppCompatActivity {

    private String liveUrl;
    private VideoView mVideoView;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.activity_live);
        playfunction();
    }


    void playfunction(){

        Intent intent = getIntent();
        liveUrl = intent.getStringExtra("liveUrl");

        mVideoView = (VideoView) findViewById(R.id.surface_view);
        if (liveUrl == "") {
            Toast.makeText(this, "播放地址为空", Toast.LENGTH_LONG).show();
            return;
        } else {
            mVideoView.setVideoPath(liveUrl);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.requestFocus();

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    // optional need Vitamio 4.0
                    mediaPlayer.setPlaybackSpeed(1.0f);
                }
            });
        }
    }
}
