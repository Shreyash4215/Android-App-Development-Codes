package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int hgt;

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        LinearLayout lr = findViewById(R.id.lnr);

        ViewGroup.LayoutParams params = editText.getLayoutParams();

        float spToPixels = 40 * getResources().getDisplayMetrics().scaledDensity;



        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Check if the touch is inside the drawable bounds

                Drawable[] drawables = editText.getCompoundDrawables();
                Drawable rightDrawable = drawables[2];

                float t;

                t =  rightDrawable.getBounds().height();
                hgt = lr.getTop();


//                Toast.makeText(getApplicationContext(), "Button !="+(editText.getRight() - rightDrawable.getBounds().width()), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "top!="+editText.getTop(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "event!="+(event.getRawY()), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "T!="+t, Toast.LENGTH_SHORT).show();

                if (event.getAction() == MotionEvent.ACTION_UP &&
                        (event.getRawX()+10 >= editText.getRight() - rightDrawable.getBounds().width()) &&
                    (event.getRawX()+10 <= (editText.getRight() - rightDrawable.getBounds().width())+ 69 )
                            && (154 <= event.getRawY()-(lr.getTop() - rightDrawable.getBounds().height()))
                        && (221 >= event.getRawY()-(lr.getTop() - rightDrawable.getBounds().height()))
                       )
                 {

//                     event.getRawY()-(editText.getTop() - rightDrawable.getBounds().height());
//                    (event.getRawX()+10 >= editText.getRight() - rightDrawable.getBounds().width())
//                    (event.getRawX()+10 <= editText.getRight() - rightDrawable.getBounds().width())+69)
                     float size = event.getRawY();
//                    int size = rightDrawable.getBounds().width();

                    Toast.makeText(getApplicationContext(), "Button Clicked!="+size, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Button Clicked!="+editText.getTop() , Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        View rootView = findViewById(android.R.id.content);

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                rootView.getWindowVisibleDisplayFrame(rect);

                int screenHeight = rootView.getHeight();
                int keyboardHeight = screenHeight - rect.bottom;
                Toast.makeText(getApplicationContext(), "screenHeight="+screenHeight, Toast.LENGTH_SHORT).show();
                // Check if the keyboard is visible
                if (keyboardHeight > screenHeight * 0.15) {
                    // Keyboard is visible, you can adjust the position of your component here
                    int newYPosition = hgt - keyboardHeight - lr.getHeight();
                    //editText.setY(newYPosition);

//                    Toast.makeText(getApplicationContext(), "new possiton!="+newYPosition, Toast.LENGTH_SHORT).show();

                } else {
                    // Keyboard is hidden, reset the position if needed
                    //int originalYPosition = // Calculate the original Y position of your component
                            //editText.setY(originalYPosition);
                }
            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
//                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.sendblkawt, 0);
                    editText.getLayoutParams().height = (int) spToPixels;
                    editText.requestLayout();
                }

                else
                {
                    Layout layout = editText.getLayout();
                    int lineCount = layout.getLineCount();

                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.sendo, 0);
                    if(lineCount>1) {
                        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                        editText.setLayoutParams(params);
                    }
                    else {
                        editText.getLayoutParams().height = (int) spToPixels;
                        editText.requestLayout();
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not needed for this example
            }
        });
    }
}