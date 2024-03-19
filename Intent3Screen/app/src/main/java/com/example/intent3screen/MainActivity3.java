package com.example.intent3screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle ban = getIntent().getExtras();

        ImageView img = findViewById(R.id.img);
        TextView txt = findViewById(R.id.txt);

        String crs = ban.getString("crs");
        String text="";

        if(crs.equals("Internet of Things"))
        {
            img.setImageResource(R.drawable.iot);
            text = ""+crs+":  \n\n  The internet of things, is a network of interrelated devices that connect and exchange data with other IoT devices and the cloud  \n\n  Eligibility: Open To All";

        }
        else if(crs.equals("Cloud Computing"))
        {
            img.setImageResource(R.drawable.clf);
            text = ""+crs+":  \n\n  Cloud computing is the delivery of different services through the Internet, including data storage, servers, databases, networking, and software.  \n\n  Eligibility: Open To All";

        }
        else
        {
            img.setImageResource(R.drawable.da);
            text = ""+crs+":  \n\n  Data Analysis is the process of systematically applying statistical and/or logical techniques to describe and illustrate, condense and recap, and evaluate data.  \n\n  Eligibility: Open To All";

        }
        txt.setText(text);
    }
}