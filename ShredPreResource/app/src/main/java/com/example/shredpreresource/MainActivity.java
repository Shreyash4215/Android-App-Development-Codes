package com.example.shredpreresource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    EditText roll,name,add;
    TextView troll,tname,tadd;
    Switch stch;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String ROLL="roll";
    public static final String NAME="name";
    public static final String ADD="add";
    public static final String SWITCH1="stch";

    private String Roll,Name,Add;
    private boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        troll = findViewById(R.id.troll);
        tname = findViewById(R.id.tname);
        tadd = findViewById(R.id.tadd);
        stch = findViewById(R.id.stch);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                troll.setText("Roll Number : "+roll.getText().toString());
                tname.setText("Name : "+name.getText().toString());
                tadd.setText("Address : "+add.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        LoadData();
        UpdateData();
    }

    public void saveData() {

        SharedPreferences sharedprefernces = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedprefernces.edit();

        editor.putString(ROLL,roll.getText().toString());
        editor.putString(NAME,name.getText().toString());
        editor.putString(ADD,add.getText().toString());
        editor.putBoolean(SWITCH1,stch.isChecked());

        editor.apply();

        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();
    }

    public void LoadData()
    {
        SharedPreferences sharedprefernces = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        Roll = sharedprefernces.getString(ROLL,"");
        Name = sharedprefernces.getString(NAME,"");
        Add = sharedprefernces.getString(ADD,"");

        switchOnOff = sharedprefernces.getBoolean(SWITCH1,false);
    }

    public void UpdateData()
    {
        troll.setText("Roll Number : "+Roll);
        tname.setText("Name : "+Name);
        tadd.setText("Address : "+Add);
        stch.setChecked(switchOnOff);
    }

}