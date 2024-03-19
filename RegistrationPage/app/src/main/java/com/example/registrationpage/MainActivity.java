package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView registrationImage;
    private EditText editTextName;
    private CheckBox checkBoxAgree;
    private RadioGroup radioGroupGender;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationImage = findViewById(R.id.registrationImage);
        editTextName = findViewById(R.id.editTextName);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                boolean agreedToTerms = checkBoxAgree.isChecked();
                int selectedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                String gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";


                String message = "Name: " + name + "\nI am not a robot: " + agreedToTerms + "\nGender: " + gender;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
