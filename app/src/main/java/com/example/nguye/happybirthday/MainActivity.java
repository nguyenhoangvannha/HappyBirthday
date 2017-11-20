package com.example.nguye.happybirthday;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtWellcome;
    private ImageButton btnWellcome;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        addEvents();
    }

    private void addEvents() {
        btnWellcome.setOnClickListener(this);
    }

    private void initComponents() {
        txtWellcome = (TextView) findViewById(R.id.txt_wellcome);
        btnWellcome = (ImageButton) findViewById(R.id.btn_wellcome);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBucThu.TTF");
        txtWellcome.setTypeface(typeface);
        mediaPlayer = MediaPlayer.create(this, R.raw.thelazysong);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_wellcome:
                mediaPlayer.stop();
                Intent intent = new Intent(MainActivity.this, MemoriesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
