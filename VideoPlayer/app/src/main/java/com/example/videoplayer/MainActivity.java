package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lst;
    ArrayAdapter adp;
    String arr[]={"mountain","waterfall","video2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.lst);

        adp = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,arr);
        lst.setAdapter(adp);

        lst.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String name = arr[i];


        Intent inten = new Intent(this,MainActivity2.class);

        Bundle ban = new Bundle();
        ban.putString("name",name);

        inten.putExtras(ban);

        startActivity(inten);
    }
}