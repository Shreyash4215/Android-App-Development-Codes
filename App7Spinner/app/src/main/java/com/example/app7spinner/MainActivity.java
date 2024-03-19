package com.example.app7spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spn1,spn2;
    ArrayList<String> games;
    ArrayAdapter adp,adp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spn1);
        spn2 = findViewById(R.id.spn2);

        games = new ArrayList<String>();
        games.add("Cricket");
        games.add("Football");
        games.add("Tennis");

            adp = ArrayAdapter.createFromResource(this,R.array.fruits, android.R.layout.simple_spinner_item);
            adp.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spn1.setAdapter(adp);

        adp2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,games);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn2.setAdapter(adp2);

        spn1.setOnItemSelectedListener(this);
        spn2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.findViewById(R.id.spn1) == spn1)
            Toast.makeText(this,spn1.getSelectedItem().toString()+" is at position "+spn1.getSelectedItemPosition(),Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,spn2.getSelectedItem().toString()+" is at position "+spn2.getSelectedItemPosition(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}