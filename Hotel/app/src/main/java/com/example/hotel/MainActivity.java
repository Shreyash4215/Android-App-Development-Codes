package com.example.hotel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton hot1,hot2;
    CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
    Button sub;
    String nme ,fedd;
    AlertDialog alrt;
    float r=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hot1 = findViewById(R.id.hot1);
        hot2 = findViewById(R.id.hot2);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);
        sub = findViewById(R.id.sub);

        sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        String name="Hotel Name : " ,fed="FeedBack : " ,rte="Rating : ";


       AlertDialog.Builder popDialog = new AlertDialog.Builder(this);

        LinearLayout linearLayout = new LinearLayout(this);
        RatingBar rating = new RatingBar(this);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        rating.setLayoutParams(lp);
        rating.setNumStars(5);
        rating.setStepSize(1);

        //add ratingBar to linearLayout
        linearLayout.addView(rating);


        popDialog.setIcon(android.R.drawable.btn_star_big_on);
        popDialog.setTitle("Add Rating: ");

        //add linearLayout to dailog
        popDialog.setView(linearLayout);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                ratiing(v);
                alrt.dismiss();

            }
        });
        alrt = popDialog.create();
        alrt.show();

        if(hot1.isChecked())
        {
            name = name + hot1.getText().toString();

            if(ch1.isChecked())
                fed = fed + " "+ch1.getText().toString();
            if(ch2.isChecked())
                fed = fed +  " "+ch2.getText().toString();
            if(ch3.isChecked())
                fed = fed +  " "+ch3.getText().toString();
        }
        else if(hot2.isChecked())
        {
            name = name+ hot2.getText().toString();

            if(ch4.isChecked())
                fed = fed + " "+ ch4.getText().toString();
            if(ch5.isChecked())
                fed = fed + " "+ ch5.getText().toString();
            if(ch6.isChecked())
                fed = fed + " "+ ch6.getText().toString();
        }

        nme = name;
        fedd=fed;
    }
    public void ratiing(float r)
    {
        String  rte = "Rating : " + r + " Star";
        AlertDialog.Builder bldr = new AlertDialog.Builder(this);
        bldr.setTitle("Rating");
        bldr.setMessage("" +nme+ "\n"+fedd+"\n"+rte);
        AlertDialog alrtt = bldr.create();
        alrtt.show();
    }
}