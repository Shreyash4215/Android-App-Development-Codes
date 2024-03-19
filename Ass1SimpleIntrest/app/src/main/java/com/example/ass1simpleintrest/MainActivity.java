package com.example.ass1simpleintrest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText tamt,tintr,tper,tsi;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tsi = findViewById(R.id.tsi);
        tamt = findViewById(R.id.tamt);
        tintr = findViewById(R.id.tintr);
        tper = findViewById(R.id.tper);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int amt,intr,per,si;

        amt = Integer.parseInt(tamt.getText().toString());
        intr = Integer.parseInt(tintr.getText().toString());
        per = Integer.parseInt(tper.getText().toString());

        si = (amt*intr*per)/100;

        tsi.setText(""+si);

    }
}