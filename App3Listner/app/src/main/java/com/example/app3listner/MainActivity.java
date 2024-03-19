package com.example.app3listner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaration
    Button btn1,btn2;
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Registration / Mapping

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        // Listner
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.findViewById(R.id.btn1) == btn1)
        {
            cnt++;
            Toast.makeText(this, "Button Clicked "+cnt+" Times", Toast.LENGTH_SHORT).show();
        }
        else if(view.findViewById(R.id.btn2) == btn2)
        {
            System.exit(0);
        }
    }
}