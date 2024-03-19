package com.example.app16_myactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText nme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        nme = findViewById(R.id.nme);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,MainActivity2.class);

        Bundle ban = new Bundle();
        ban.putString("name",nme.getText().toString());

        i.putExtras(ban);

        startActivity(i);
    }
}