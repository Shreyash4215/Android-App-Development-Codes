package com.example.intent3screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    String crs;
    Button yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.txt);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.No);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        Bundle ban = getIntent().getExtras();

        crs = ban.getString("crs");

        txt.setText("  Selected Department Elective is "+crs+"! \n  Do you want proceed?  ");
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if(view.findViewById(R.id.yes) == yes)
        {
            i = new Intent(this,MainActivity3.class);

            Bundle ban = new Bundle();

            ban.putString("crs",crs);

            i.putExtras(ban);
        }
        else
        {
            i = new Intent(this,MainActivity.class);

            Bundle ban = new Bundle();
        }

        startActivity(i);
    }
}