package com.taek_aaa.opencv;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

/**
 * Created by taek_aaa on 2017. 9. 13..
 */

public class TeaserActivity extends AppCompatActivity {
    private VideoView videoView;
    private Intent intent;
    private Uri video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaser);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = (VideoView)findViewById(R.id.teaser_video);
        video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.teaser);
        videoView.setVideoURI(video);
        intent = new Intent(this,OpeningActivity.class);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                startActivity(intent);
                //write your code after complete video play
            }
        });

        playVideo();
    }
    private void playVideo() {
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
                videoView.start();
            }
        });
    }
}