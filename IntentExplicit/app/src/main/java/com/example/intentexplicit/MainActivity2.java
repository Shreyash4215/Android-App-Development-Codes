package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.txt);

        Bundle ban = getIntent().getExtras();

        txt.setText("Name: "+ban.getString("nme")+"\nEmail:"+ban.getString("mail")+"\nPhone: "+ban.getString("phone"));
    }
}