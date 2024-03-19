package com.example.netclan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Refine extends AppCompatActivity implements View.OnClickListener
{

    SQLiteDatabase db;
    Button cofe,bus,hob,frnd,movie,din,dat,matr,save;
    EditText abt;
    Cursor c;
    int sldvlue,avail;
    String abut,btnName;
    Spinner spn;
    SeekBar sldr;
    TextView tooltipText,wrdcnt;
    View tooltipView;
    LinearLayout bckgrnd;
    List<String> btns;

    private Handler viewHandler = new Handler();
    private PopupWindow tooltipPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        btns = new ArrayList<String>();

        Toolbar tolbr = findViewById(R.id.toolbar);
        spn = findViewById(R.id.availbty);
        sldr = findViewById(R.id.slider);
        cofe= findViewById(R.id.cofe);
        bus= findViewById(R.id.bus);
        hob= findViewById(R.id.hob);
        frnd= findViewById(R.id.frnd);
        movie= findViewById(R.id.movie);
        din= findViewById(R.id.din);
        dat= findViewById(R.id.dat);
        matr= findViewById(R.id.matr);
        save= findViewById(R.id.save);
        abt= findViewById(R.id.abt);
        wrdcnt= findViewById(R.id.wrdcnt);

        float spToPixels = 40 * getResources().getDisplayMetrics().scaledDensity;

        cofe.setOnClickListener(this);
        bus.setOnClickListener(this);
        hob.setOnClickListener(this);
        frnd.setOnClickListener(this);
        movie.setOnClickListener(this);
        din.setOnClickListener(this);
        dat.setOnClickListener(this);
        matr.setOnClickListener(this);
        save.setOnClickListener(this);

        setSupportActionBar(tolbr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backarrow);

        db = openOrCreateDatabase("MyDB", Context.MODE_PRIVATE,null);
      //  db.execSQL("Create table if not exists MySelf(srno int,avail int,about varchar,dist int,purp varchar)");


       // Specify the layout to use when the list of choices appears
        ArrayAdapter adp = ArrayAdapter.createFromResource(this,R.array.fruits, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adp);
        spn.setDropDownVerticalOffset(115);
        spn.setDropDownHorizontalOffset(7);

        ViewGroup.LayoutParams params = abt.getLayoutParams();

        sldr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    sldvlue = progress;
                    tooltipPopup.dismiss();
                    showTooltip(progress);
                }catch (Exception epppp){}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something when the user starts interacting with the SeekBar
                showTooltip(seekBar.getProgress());
                tooltipPopup.dismiss();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do something when the user stops interacting with the SeekBar
            }
        });

        abt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                    abt.getLayoutParams().height = (int) spToPixels;
                    abt.requestLayout(); // To change the height of EditText Dynammically
                }
                else
                {
                    try {
                        Layout layout = abt.getLayout();
                        int lineCount = layout.getLineCount();


                        if(lineCount>1) {
                            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;// To change the height of EditText Dynammically
                            abt.setLayoutParams(params);
                        }
                        else {
                            abt.getLayoutParams().height = (int) spToPixels;// To change the height of EditText Dynammically
                            abt.requestLayout();
                        }
                    }catch (Exception e){}
                }
            }

            @Override//To change the possition of Button
            public void afterTextChanged(Editable editable) {
                int numberOfAlphabets= countAlphabets(editable.toString());

                if (numberOfAlphabets > 250) {
                    editable.delete(250, editable.length());
                    numberOfAlphabets = 250;
                }

                wrdcnt.setText(numberOfAlphabets+"/250");
            }
        });

        fetchInfo();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Handle the Up button click or Back button press here
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
                onBackPressed(); // Or you can perform your custom action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void showTooltip(int progress) {
        // Initialize tooltip layout
        tooltipView = LayoutInflater.from(this).inflate(R.layout.tooltip_layout, null);
        tooltipText = tooltipView.findViewById(R.id.tooltipText);
        bckgrnd = tooltipView.findViewById(R.id.lnrlay);
        tooltipText.setText(String.valueOf(progress));

        // Initialize PopupWindow
        tooltipPopup = new PopupWindow(tooltipView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tooltipPopup.setOutsideTouchable(true);
        tooltipPopup.setFocusable(false);

        // Calculate the position of the tooltip
        Rect thumbRect = getThumbBounds();
        int xPosition = thumbRect.centerX() - tooltipPopup.getContentView().getWidth() / 2;
        int yPosition = thumbRect.top;

        // Show the tooltip at the calculated position
        tooltipPopup.showAsDropDown(sldr, xPosition, yPosition-180);
    }

    private Rect getThumbBounds() {
        // Calculate the bounds of the thumb within the SeekBar
        Rect thumbRect = new Rect();
        sldr.getThumb().copyBounds(thumbRect);
        return thumbRect;
    }

    @Override
    public void onClick(View view) {
        if (view.findViewById(R.id.cofe) == cofe)
            toggleButtonState(R.id.cofe);
        else if (view.findViewById(R.id.bus) == bus)
            toggleButtonState(R.id.bus);
        else if (view.findViewById(R.id.hob) == hob)
            toggleButtonState(R.id.hob);
        else if (view.findViewById(R.id.frnd) == frnd)
            toggleButtonState(R.id.frnd);
        else if (view.findViewById(R.id.movie) == movie)
            toggleButtonState(R.id.movie);
        else if (view.findViewById(R.id.din) == din)
            toggleButtonState(R.id.din);
        else if (view.findViewById(R.id.dat) == dat)
            toggleButtonState(R.id.dat);
        else if (view.findViewById(R.id.matr) == matr)
            toggleButtonState(R.id.matr);
        else if (view.findViewById(R.id.save) == save)
        {
            avail = spn.getSelectedItemPosition();
            abut = abt.getText().toString();
            try {
                    String qr = "update MySelf set avail=" + avail + ",about='" + abut + "',dist=" + sldvlue+ ",purp='" + btnName + "'";
                    db.execSQL(qr);
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }catch (Exception ep){            }
        }
    }
    private int countAlphabets(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    private void toggleButtonState(int buttonId) {

        Button button = findViewById(buttonId);
        // Toggle the selected state of the button
        button.setSelected(!button.isSelected());

        if (button.isSelected())
            btns.add(getResources().getResourceEntryName(buttonId));
      else
            btns.remove(getResources().getResourceEntryName(buttonId));

        btnName=btns.toString();
    }


    void fetchInfo() {
        try {
            c = db.rawQuery("select * from MySelf where srno=1", null);
            c.moveToNext();
            avail = Integer.parseInt(c.getString(1));
            abut = c.getString(2);
            sldvlue = Integer.parseInt(c.getString(3));
            btnName = c.getString(4);

            spn.setSelection(avail);
            abt.setText(abut);
            sldr.setProgress(sldvlue);

            btnName=btnName.replaceAll("[^a-zA-Z,]", "");

            String button[]=btnName.split(",");

            for(int i=0;i<button.length;i++) {
                    Field resourceField = R.id.class.getField(button[i]);
                    int resourceId = resourceField.getInt(null);
                    Button btn=findViewById(resourceId);
                    btn.performClick();
            }

        } catch (Exception ep) {        }
    }
}