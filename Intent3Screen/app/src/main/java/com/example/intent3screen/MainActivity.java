package com.example.intent3screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String crs="";

        if(view.findViewById(R.id.rb1) == rb1)
            crs = rb1.getText().toString();
        else if(view.findViewById(R.id.rb2) == rb2)
            crs = rb2.getText().toString();
        else if(view.findViewById(R.id.rb3) == rb3)
            crs = rb3.getText().toString();

        Intent i = new Intent(this,MainActivity2.class);

        Bundle ban = new Bundle();

        ban.putString("crs",crs);

        i.putExtras(ban);
        startActivity(i);

    }
}