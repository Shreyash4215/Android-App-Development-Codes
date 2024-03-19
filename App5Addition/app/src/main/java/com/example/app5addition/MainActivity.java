package com.example.app5addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add,clr,ext;
    EditText txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        clr = findViewById(R.id.clr);
        ext = findViewById(R.id.ext);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);


        add.setOnClickListener(this);
        clr.setOnClickListener(this);
        ext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            String ch= (String) view.getTag();
        Toast.makeText(this, "ch="+ch, Toast.LENGTH_SHORT).show();
        try {

            if (view.findViewById(R.id.add) == add) {
                if (txt1.getText().length() > 0 && txt2.getText().length() > 0) {
                    Double a = Double.parseDouble(txt1.getText().toString());
                    Double b = Double.parseDouble(txt2.getText().toString());
                    Double c = a + b;

                    DecimalFormat decimalFormat = new DecimalFormat("#.###");
                    decimalFormat.setDecimalSeparatorAlwaysShown(false);
                    String formattedResult = decimalFormat.format(c);

                    txt3.setText("" + formattedResult);
                } else
                    Toast.makeText(this, "Two Number Required", Toast.LENGTH_SHORT).show();
            } else if (view.findViewById(R.id.clr) == clr) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt1.requestFocus();
            } else if (view.findViewById(R.id.ext) == ext) {
                System.exit(0);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }
}