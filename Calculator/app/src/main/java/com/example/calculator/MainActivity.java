package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bmin,bmul,bdiv,bdot,bext,bclr,bans;
    TextView txt1;
    Double p,q,ans;
    static int c=0;
    String n="",o="";
    DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bplus = findViewById(R.id.bplus);
        bmin = findViewById(R.id.bmin);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);
        bdot = findViewById(R.id.bdot);
        bclr = findViewById(R.id.bclr);
        bext = findViewById(R.id.bext);
        bans = findViewById(R.id.bans);
        txt1 = findViewById(R.id.txt1);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bmin.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bclr.setOnClickListener(this);
        bext.setOnClickListener(this);
        bans.setOnClickListener(this);

        b0.setTag("0");
        b1.setTag("1");
        b2.setTag("2");
        b3.setTag("3");
        b4.setTag("4");
        b5.setTag("5");
        b6.setTag("6");
        b7.setTag("7");
        b8.setTag("8");
        b9.setTag("9");
        bdot.setTag(".");
        bplus.setTag("+");
        bmin.setTag("-");
        bmul.setTag("*");
        bdiv.setTag("/");
    }

    @Override
    public void onClick(View view) {
        try {
            String ch = (String) view.getTag();

             try {
                  if (".".equals(ch) && c == 0) {
                        n = n + ch;
                        c++;
                    }
                    if (0 <= Integer.parseInt(ch))
                        n = n + ch;
                } catch (Exception ex) {
                }

            if( ch=="0" || ch=="1" || ch=="2" || ch=="3" || ch=="4" || ch=="5" || ch=="6" || ch=="7" || ch=="8" || ch=="9" || ch==".")
                txt1.setText("" + n);


            if("+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch))
            {
                c=0;
                o=ch;
                p=Double.parseDouble(txt1.getText().toString());
                txt1.setText("");
                n="";
            }

            if(view.findViewById(R.id.bans)==bans)
            {
                q=Double.parseDouble(txt1.getText().toString());

                swtch(o);
                n="";
            }
            if(view.findViewById(R.id.bclr)==bclr)
            {
                c=0;
                n="";
                txt1.setText("");
            }
            if(view.findViewById(R.id.bext)==bext)
                System.exit(0);
        }
        catch(ArithmeticException ae)
        {
            n="";
            Toast.makeText(this,"Infinity",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this,""+e,Toast.LENGTH_SHORT).show();
        }


    }

    public void swtch(String op)
    {
        decimalFormat = new DecimalFormat("#.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        switch (op)
        {
            case "+":
                ans=p+q;
                break;
            case "-":
                ans=p-q;
                break;
            case "*":
                ans=p*q;
                break;
            case "/":
                ans=p/q;
                break;
        }
        String result = decimalFormat.format(ans);
        txt1.setText(""+result);
    }
}