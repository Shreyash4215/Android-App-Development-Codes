package com.example.color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView exampleTxt = findViewById(R.id.exampleText);
        exampleTxt.setTextColor(Color.parseColor("#0F9D58"));

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        exampleTxt.setTypeface(type);
    }
}