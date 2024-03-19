package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,Menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.i1) {
            tv.setText("Mathematics");
            return true;
        } else if (itemId == R.id.i2) {
            tv.setText("Chemistry");
            return true;
        } else if (itemId == R.id.i3) {
            tv.setText("Computer Science");
            return true;
        } else if (itemId == R.id.i4) {
            tv.setText("Big Data Analytics");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
