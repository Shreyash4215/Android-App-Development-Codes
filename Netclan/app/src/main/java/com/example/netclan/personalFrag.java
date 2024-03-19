package com.example.netclan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class personalFrag extends Fragment {

    private Handler messageHandler = new Handler();
    List<MsgDTO> msgDtoList = new ArrayList<MsgDTO>();//messages stored for ChatScreen
    RecyclerView msgRecyclerView;
    Button btn;
    MsgAdapter msgAdapter = new MsgAdapter(msgDtoList);
    SearchView srch;
    SQLiteDatabase db;
    Cursor c;
    LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_personal, container, false);

        msgRecyclerView = view.findViewById(R.id.chat_recycler_view);
        srch = view.findViewById(R.id.searchView);
        btn = view.findViewById(R.id.btn);

        // Inside your Fragment class
        db = requireContext().openOrCreateDatabase("MyDB", Context.MODE_PRIVATE, null);

        linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setStackFromEnd(true);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        c = db.rawQuery("select * from MyTab", null);
        while (c.moveToNext())
        {
            String ini = String.valueOf(c.getString(0).charAt(0))+String.valueOf(c.getString(1).charAt(0));
            ini = ini.toUpperCase();

            MsgDTO msgDto = new MsgDTO(c.getString(0)+" "+c.getString(1),ini,""+c.getString(2),""+c.getString(3),"Within "+c.getString(4),Integer.parseInt(c.getString(5)),""+c.getString(6),""+c.getString(7),""+c.getString(8),""+c.getString(9));
            msgDtoList.add(msgDto);
            msgRecyclerView.setAdapter(msgAdapter);
        }
        msgRecyclerView.smoothScrollToPosition(0);

        msgRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private static final int HIDE_THRESHOLD = 20; // Adjust this threshold as needed
            private int scrolledDistance = 0;
            private boolean controlsVisible = true;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
                    // Hide your button here
                    btn.setVisibility(View.GONE);
                    controlsVisible = false;
                    scrolledDistance = 0;
                } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
                    // Show your button here
                    controlsVisible = true;
                    btn.setVisibility(View.VISIBLE);
                    scrolledDistance = 0;
                }
                if ((controlsVisible && dy > 0) || (!controlsVisible && dy < 0)) {
                    scrolledDistance += dy;
                }
            }
        });

        // Set up the SearchView listener
        srch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search when the user presses the "Search" button on the keyboard
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the list as the user types in the SearchView
                Toast.makeText(requireContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                msgDtoList.clear();

                c = db.rawQuery("select * from MyTab where fname LIKE '%"+newText+"%' OR lnme LIKE '%"+newText+"%'" , null);
                while (c.moveToNext())
                {
                    String ini = String.valueOf(c.getString(0).charAt(0))+String.valueOf(c.getString(1).charAt(0));
                    ini = ini.toUpperCase();

                    MsgDTO msgDto = new MsgDTO(c.getString(0)+" "+c.getString(1),ini,""+c.getString(2),""+c.getString(3),"Within "+c.getString(4),Integer.parseInt(c.getString(5)),""+c.getString(6),""+c.getString(7),""+c.getString(8),""+c.getString(9));
                    msgDtoList.add(msgDto);
                    msgRecyclerView.setAdapter(msgAdapter);
                }
                msgRecyclerView.smoothScrollToPosition(0);
                return false;
            }
        });

        return view;
    }
}