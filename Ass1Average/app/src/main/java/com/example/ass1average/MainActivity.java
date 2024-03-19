package com.example.ass1average;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText tamt,tintr,tper,tsi,tsub4,tsub5;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tsi = findViewById(R.id.tsi);
        tamt = findViewById(R.id.tamt);
        tintr = findViewById(R.id.tintr);
        tper = findViewById(R.id.tper);
        tsub4 = findViewById(R.id.tsub4);
        tsub5 = findViewById(R.id.tsub5);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int amt,intr,per,sub4,sub5,avg,sum;

        amt = Integer.parseInt(tamt.getText().toString());
        intr = Integer.parseInt(tintr.getText().toString());
        per = Integer.parseInt(tper.getText().toString());
        sub4 = Integer.parseInt(tsub4.getText().toString());
        sub5 = Integer.parseInt(tsub5.getText().toString());

        sum =amt+intr+per+sub4+sub5;
        avg = sum/5;

        tsi.setText(""+avg);

    }
}