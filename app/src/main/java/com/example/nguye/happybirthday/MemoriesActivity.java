package com.example.nguye.happybirthday;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoriesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lvSongs;
    private ArrayList<Song> songs;
    private SongsAdapter songsAdapter;
    private MediaPlayer player;
    private boolean isPlaying = false;
    private int[] arrIntSongs = {R.raw.thelazysong,R.raw.thunder, R.raw.too_good_at_goodbyes, R.raw.attention};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);
        initComponents();
        addEvents();
    }

    private void addEvents() {
        lvSongs.setOnItemClickListener(this);
    }

    private void initComponents() {
        lvSongs = findViewById(R.id.lv_songs);
        songs = new ArrayList<Song>();
        AssetManager assetManager = getAssets();
        String[] arrStrSongs = {"The lazy song", "Thunder", "Too good at goodbyes", "Attention"};
        for(int i = 0; i < arrStrSongs.length; i++){
            player = MediaPlayer.create(this, arrIntSongs[i]);
            songs.add(new Song(arrStrSongs[i], player.getDuration()/ 1000, "Not set yet"));
            player.release();
        }
        songsAdapter = new SongsAdapter(this, songs);
        lvSongs.setAdapter(songsAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(isPlaying){
            player.release();
            player = MediaPlayer.create(this, arrIntSongs[i]);
            player.start();
        } else{
            player = MediaPlayer.create(this, arrIntSongs[i]);
            player.start();
            isPlaying = true;
        }
    }
}
