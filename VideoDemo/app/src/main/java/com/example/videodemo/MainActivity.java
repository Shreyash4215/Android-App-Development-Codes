package com.example.videodemo;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.vp);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        int resourceId=0;
        try {
            Field resourceField = R.raw.class.getField(res);
            resourceId = resourceField.getInt(null);
        }catch (Exception ep){}



        String videoPath = "android.resource://" + getPackageName() + "/" + resourceId;



        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
