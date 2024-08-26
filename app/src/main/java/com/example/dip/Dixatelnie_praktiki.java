package com.example.dip;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dixatelnie_praktiki extends AppCompatActivity {

    VideoView videoView, videoView1, videoView2;
    MediaController mediaController, mediaController1, mediaController2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dixatelnie_praktiki);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        videoView = findViewById(R.id.Video);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.morning);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        Button playButton = findViewById(R.id.playButton);
        Button pauseButton = findViewById(R.id.pauseButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        videoView1 = findViewById(R.id.Video1);
        videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.air2);
        mediaController1 = new MediaController(this);
        videoView1.setMediaController(mediaController1);

        Button playButton1 = findViewById(R.id.playButton1);
        Button pauseButton1 = findViewById(R.id.pauseButton1);

        playButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView1.start();
            }
        });
        pauseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView1.pause();
            }
        });

        videoView2 = findViewById(R.id.Video2);
        videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.focus);
        mediaController2 = new MediaController(this);
        videoView2.setMediaController(mediaController2);

        Button playButton2 = findViewById(R.id.playButton2);
        Button pauseButton2 = findViewById(R.id.pauseButton2);

        playButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView2.start();
            }
        });
        pauseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView2.pause();
            }
        });
    }
}