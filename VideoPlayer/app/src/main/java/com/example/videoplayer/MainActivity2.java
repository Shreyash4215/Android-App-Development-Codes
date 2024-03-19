package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.lang.reflect.Field;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private VideoView videoView;

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = findViewById(R.id.vp);
        btn1 = findViewById(R.id.btn1);

        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        Bundle ban = getIntent().getExtras();
        String res = ban.getString("name");

        int resourceId=0;
        try {
            Field resourceField = R.raw.class.getField(res);
            resourceId = resourceField.getInt(null);
        }catch (Exception ep){}

        String videoPath = "android.resource://" + getPackageName() + "/" + resourceId;

        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnCompletionListener(this);

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent inten = new Intent(this,MainActivity.class);
        startActivity(inten);

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Intent inten = new Intent(this,MainActivity.class);
        startActivity(inten);
    }
}