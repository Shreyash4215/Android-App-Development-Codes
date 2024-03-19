package com.example.app14_imageswitcher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageSwitcher imgsw;
    Button pre,nxt;
    int myimg[]=new int[]{R.drawable.blue,R.drawable.pink,R.drawable.yellow,R.drawable.red};
    int i=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgsw = findViewById(R.id.imgsw);
        pre = findViewById(R.id.pre);
        nxt = findViewById(R.id.nxt);

        imgsw.setFactory(() -> {
            ImageView img = new ImageView(getApplicationContext());
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return img;
        });

        pre.setOnClickListener(this);
        nxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.findViewById(R.id.pre) == pre)
        {
            i--;

            if(i<=-1)
                i=myimg.length-1;

            imgsw.setImageResource(myimg[i]);
        }
        else
        {
            i++;

            if(i==myimg.length-1)
                i=0;

            imgsw.setImageResource(myimg[i]);
        }

    }
}