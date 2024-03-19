package com.example.apps8additeminspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Button btn;
    Spinner spn;
    EditText txt;
    ArrayList games;
    ArrayAdapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        spn = findViewById(R.id.spn);
        txt = findViewById(R.id.txt);

        games = new ArrayList<String>();
        games.add("Cricket");
        games.add("Football");
        games.add("tennis");

        adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,games);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn.setAdapter(adp);

        btn.setOnClickListener(this);
        spn.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

            games.add(txt.getText().toString());
            adp.notifyDataSetChanged();

            txt.setText("");
            txt.requestFocus();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this,spn.getSelectedItem()+" is at position "+spn.getSelectedItemPosition(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}