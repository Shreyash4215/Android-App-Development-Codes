package com.example.app12_sqlitedb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText troll,tname,tage;
    Button clr,insrt,upd,dlt,ldall,nxt,pre,rslt,ext,swall;
    RadioButton rbroll,rbnme,rbage;

    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("MyDB", Context.MODE_PRIVATE,null);
        db.execSQL("Create table if not exists MyTab(rno varchar,name varchar,age varchar)");

        troll = findViewById(R.id.troll);
        tname = findViewById(R.id.tname);
        tage = findViewById(R.id.tage);
        clr = findViewById(R.id.clr);
        insrt = findViewById(R.id.insrt);
        upd = findViewById(R.id.upd);
        dlt = findViewById(R.id.dlt);
        ldall = findViewById(R.id.ldall);
        nxt = findViewById(R.id.nxt);
        pre = findViewById(R.id.pre);
        rslt = findViewById(R.id.rslt);
        ext = findViewById(R.id.ext);
        swall = findViewById(R.id.swall);
        rbroll = findViewById(R.id.rbroll);
        rbnme = findViewById(R.id.rbnme);
        rbage = findViewById(R.id.rbage);

        clr.setOnClickListener(this);
        insrt.setOnClickListener(this);
        upd.setOnClickListener(this);
        dlt.setOnClickListener(this);
        ldall.setOnClickListener(this);
        nxt.setOnClickListener(this);
        pre.setOnClickListener(this);
        swall.setOnClickListener(this);
        rslt.setOnClickListener(this);
        ext.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        try
        {
            if (view.findViewById(R.id.clr) == clr)
            {
                clear();
            }
            else if (view.findViewById(R.id.insrt) == insrt)
            {
                if (troll.length() == 0 || tname.length() == 0 || tage.length() == 0)
                    Toast.makeText(this, "All Fields are Required !!!",Toast.LENGTH_SHORT).show();
                else
                {
                    String qr = "insert into MyTab values('"+troll.getText().toString()+"','"+tname.getText().toString()+"','"+tage.getText().toString()+"')";
                    db.execSQL(qr);
                    Toast.makeText(this, "Record inserted",Toast.LENGTH_SHORT).show();
                    clear();
                }

            }
            else if (view.findViewById(R.id.upd) == upd)
            {
                if (troll.length() == 0 || tname.length() == 0 || tage.length() == 0)
                    Toast.makeText(this, "All Fields are Required !!!",Toast.LENGTH_SHORT).show();
                else
                {
                    String qr = "update MyTab set name='"+tname.getText().toString()+"', age='"+tage.getText().toString()+"' where rno ='"+troll.getText().toString()+"'";
                    db.execSQL(qr);
                    Toast.makeText(this, "Record Updated",Toast.LENGTH_SHORT).show();
                    clear();
                }

            }
            else if (view.findViewById(R.id.dlt) == dlt)
            {
                if (troll.length() == 0 )
                    Toast.makeText(this, "Please Enter Roll No !!!",Toast.LENGTH_SHORT).show();
                else
                {
                    String qr = "delete from MyTab where rno ='"+troll.getText().toString()+"'";
                    db.execSQL(qr);
                    Toast.makeText(this, "Record Deleted",Toast.LENGTH_SHORT).show();
                    clear();
                }

            }
            else if (view.findViewById(R.id.ldall) == ldall)
            {
                try
                {
                    c = db.rawQuery("select * from MyTab order by rno", null);
                    c.moveToFirst();
                    troll.setText(c.getString(0));
                    tname.setText(c.getString(1));
                    tage.setText(c.getString(2));

                    troll.setEnabled(false);
                    Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
                }
                catch (CursorIndexOutOfBoundsException exx)
                {
                    Toast.makeText(this, "No records found. Table is Empty", Toast.LENGTH_SHORT).show();
                }

            }
            else if (view.findViewById(R.id.pre) == pre)
            {
                c.moveToPrevious();

                if(c.isBeforeFirst()) {
                    c.moveToFirst();
                    Toast.makeText(this, "You are on First record", Toast.LENGTH_SHORT).show();
                }
                troll.setText(c.getString(0));
                tname.setText(c.getString(1));
                tage.setText(c.getString(2));

            }
            else if (view.findViewById(R.id.nxt) == nxt)
            {
                c.moveToNext();

                if(c.isAfterLast()) {
                    c.moveToLast();
                    Toast.makeText(this, "You are on last record", Toast.LENGTH_SHORT).show();
                }
                troll.setText(c.getString(0));
                tname.setText(c.getString(1));
                tage.setText(c.getString(2));

            }
            else if (view.findViewById(R.id.swall) == swall)
            {
                String temp;
                StringBuffer sb = new StringBuffer();

                c = db.rawQuery("select * from MyTab order by rno", null);
                while (c.moveToNext())
                {
                    sb.append("\n Roll No = " + c.getString(0));
                    sb.append(" Name = " + c.getString(1));
                    sb.append(" Age = " + c.getString(2)+"\n");
                }
                temp = sb.toString();
                if(temp.length() == 0)
                    refresh("DB Records", "No Record Found");
                else
                    refresh("DB Records", temp);

            }
            else if (view.findViewById(R.id.rslt) == rslt)
            {
                int flg = 0;
                String temp;
                StringBuffer sb = new StringBuffer();

                if (rbroll.isChecked())
                {
                    if (troll.getText().length() == 0)
                        Toast.makeText(this, "Enter Roll No to Search Record", Toast.LENGTH_SHORT).show();
                    else
                    {
                        flg = 1;
                        c = db.rawQuery("select * from MyTab where rno='" + troll.getText().toString() + "' order by rno", null);
                    }
                }
                else if (rbnme.isChecked())
                {
                    if (tname.getText().length() == 0)
                        Toast.makeText(this, "Enter Name to Search Record", Toast.LENGTH_SHORT).show();
                    else
                    {
                        flg = 1;
                        c = db.rawQuery("select * from MyTab where name like '%" + tname.getText().toString() + "%' order by rno", null);
                    }
                }
                else
                {
                    if (tage.getText().length() == 0)
                        Toast.makeText(this, "Enter Age to Search Record", Toast.LENGTH_SHORT).show();
                    else
                    {
                        flg = 1;
                        c = db.rawQuery("select * from MyTab where age='" + tage.getText().toString() + "' order by rno", null);
                    }
                }

                if (flg == 1)
                {
                    if(c.getCount() > 0) {
                        while (c.moveToNext()) {
                            sb.append("\n Roll No = " + c.getString(0));
                            sb.append(" Name = " + c.getString(1));
                            sb.append(" Age = " + c.getString(2) + "\n");
                        }
                        temp = sb.toString();
                        refresh("Search Result", temp);
                    }
                    else
                        refresh("Search Result", "No Record Found");
                }
            }
            else
            {
                System.exit(0);
            }
        }catch (Exception e) {
        refresh("Exception", e.toString());
    }
    }

    public void refresh(String ttl, String msg)
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(ttl);
        ad.setMessage(msg);
        ad.show();
    }

    public void clear()
    {
        troll.setText("");
        tname.setText("");
        tage.setText("");
        troll.requestFocus();
        troll.setEnabled(true);
    }
}