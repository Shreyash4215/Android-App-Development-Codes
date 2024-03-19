package com.example.pythonasbackenddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    Python python;
    PyObject pyObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Button add;

        add = findViewById(R.id.add);

        python = Python.getInstance();
        pyObject = python.getModule("back");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = pyObject.callAttr("add_numbers", 9, 3).toJava(int.class);

                Toast.makeText(getApplicationContext(),"Result="+result,Toast.LENGTH_SHORT).show();


            }
        });
    }
}