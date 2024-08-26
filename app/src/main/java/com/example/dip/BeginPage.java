package com.example.dip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.AsyncTask;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlinx.coroutines.Delay;

public class BeginPage extends AppCompatActivity {
    TextView text3;
    TextView text4;
    Animation Splash_top, Splash_bottom;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_begin_page);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BeginPage.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

        //Делаю анимацию начального экрана
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);

        Splash_top = AnimationUtils.loadAnimation(this, R.anim.splash_top);
        Splash_bottom = AnimationUtils.loadAnimation(this, R.anim.splash_bottom);

        text3.setAnimation(Splash_top);
        text4.setAnimation(Splash_top);

    }
}