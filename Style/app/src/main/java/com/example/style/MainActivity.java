package com.example.style;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.txt);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Typeface tf = Typeface.createFromAsset(getAssets(), "montage.otf");
        txt.setTextAppearance(R.style.StyleSheet);
        txt.setTypeface(tf);


    }
}