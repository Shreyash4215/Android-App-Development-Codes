package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,MainActivity2.class);

        Bundle ban = new Bundle();

        ban.putString("nme",txt1.getText().toString());
        ban.putString("mail",txt2.getText().toString());
        ban.putString("phone",txt3.getText().toString());

        i.putExtras(ban);
        startActivity(i);

    }
}