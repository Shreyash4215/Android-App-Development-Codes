    package com.example.graphics;

    import androidx.appcompat.app.AppCompatActivity;

    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.drawable.BitmapDrawable;
    import android.os.Bundle;
    import android.widget.ImageView;

    public class MainActivity extends AppCompatActivity {

        ImageView img;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Bitmap bit = Bitmap.createBitmap(720,1280,Bitmap.Config.ARGB_8888);
            img = findViewById(R.id.img);
            img.setBackgroundDrawable(new BitmapDrawable(bit));

            Canvas can = new Canvas(bit);
            Paint p = new Paint();

            p.setColor(Color.BLUE);
            p.setTextSize(50);
            can.drawText("Rectangle",420,150,p);
            can.drawRect(400,200,650,700,p);
            p.setColor(Color.RED);
            can.drawText("Circle", 120, 150, p);
            can.drawCircle(200, 350, 150, p);
            p.setColor(Color.GREEN);
            can.drawText("Square", 120, 800, p);
            can.drawRect(50, 850, 350, 1150, p);
            p.setColor(Color.BLACK);
            can.drawText("Line", 480, 800, p);
            can.drawLine(520, 850, 520, 1150, p);
        }
    }