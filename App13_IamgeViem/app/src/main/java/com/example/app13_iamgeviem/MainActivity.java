package com.example.app13_iamgeviem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button pink,ylw,blue,red;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pink = findViewById(R.id.pink);
        blue = findViewById(R.id.blue);
        ylw = findViewById(R.id.ylw);
        red = findViewById(R.id.red);
        img = findViewById(R.id.img);

        pink.setOnClickListener(this);
        blue.setOnClickListener(this);
        ylw.setOnClickListener(this);
        red.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.findViewById(R.id.blue) == blue)
            img.setImageResource(R.drawable.blue);
        else if(view.findViewById(R.id.ylw) == ylw)
            img.setImageResource(R.drawable.yellow);
        else if(view.findViewById(R.id.red) == red)
            img.setImageResource(R.drawable.red);
        else
            img.setImageResource(R.drawable.pink);
    }
}