package com.example.ass1hobbies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox ch1,ch2,ch3;
    RadioButton rb1,rb2;
    TextView infoo;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);

        infoo = findViewById(R.id.info);
        txt = findViewById(R.id.txt1);

        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String info="Name : "+txt.getText().toString()+"\n\nClass: ";
        String Hobby ="\n\nHobbies: ";


        if(rb1.isChecked())
        {
            info = info + rb1.getText().toString();
        }
        else
        {
            info = info + rb2.getText().toString();
        }

        if(ch1.isChecked())
        {
            Hobby = Hobby + " " + ch1.getText().toString();
        }
        if(ch2.isChecked())
        {
            Hobby = Hobby + " " + ch2.getText().toString();
        }
        if(ch3.isChecked())
        {
            Hobby = Hobby + " " + ch3.getText().toString();
        }

        info = info + Hobby;

        infoo.setText(""+info);
    }
}