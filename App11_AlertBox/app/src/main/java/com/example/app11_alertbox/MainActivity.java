package com.example.app11_alertbox;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(btn1 == view.findViewById(R.id.btn1))
        {
            AlertDialog.Builder bldr = new AlertDialog.Builder(this);
            bldr.setTitle("Demo");
            bldr.setMessage("this is demo alert dailog");
            AlertDialog alrt = bldr.create();
            alrt.show();
        }
        else if(btn2 == view.findViewById(R.id.btn2))
        {
            AlertDialog.Builder bldr = new AlertDialog.Builder(this);
            bldr.setTitle("DELETE");
            bldr.setMessage("Do You Want To Delete");
            bldr.setCancelable(false);

         //   bldr.setPositiveButton("YES", (dialogInterface, i) -> Toast.makeText(getApplicationContext(),"Record Deleted",Toast.LENGTH_SHORT).show());
           // bldr.setNegativeButton("No",((dialogInterface, i) -> Toast.makeText(getApplicationContext(),"Record Deleted",Toast.LENGTH_SHORT).show()));

            bldr.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Record Deleted",Toast.LENGTH_SHORT).show();
                        }
                    });
            bldr.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),"No Button Selected",Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alrt = bldr.create();
            alrt.show();
        }
    }
}