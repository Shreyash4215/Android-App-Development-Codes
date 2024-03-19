package com.example.app7radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox ch1,ch2;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);


        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.findViewById(R.id.ch1) == ch1)
        {
            if(ch1.isChecked())
            {
                Toast.makeText(this, ch1.getText().toString()+" is Checked", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, ch1.getText().toString()+" is Unchecked", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.findViewById(R.id.ch2) == ch2)
        {
            if(ch2.isChecked())
            {
                Toast.makeText(this, ch2.getText().toString()+" is Checked", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, ch2.getText().toString()+" is Unchecked", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.findViewById(R.id.rb1) == rb1 || view.findViewById(R.id.rb2) == rb2)
        {
            if(rb1.isChecked())
            {
                Toast.makeText(this, rb1.getText().toString()+" is Checked", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, rb2.getText().toString()+" is Checked", Toast.LENGTH_SHORT).show();
            }
        }

    }
}