package com.example.netclan;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//java class to handle the layout of bubble meassages
public class MsgViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout bubble_layout;
    LinearLayout bubble2_layout;
    TextView bubble_txt,bubble2_txt,location,profession,dist,abt1,abt2,abt3,abt4;
    ProgressBar progrs;

    public MsgViewHolder(View itemView) {
        super(itemView);

        if(itemView!=null) {
            bubble_layout = (RelativeLayout) itemView.findViewById(R.id.bubble_layout);
            bubble_txt = (TextView) itemView.findViewById(R.id.name);
            location = (TextView) itemView.findViewById(R.id.location);
            profession = (TextView) itemView.findViewById(R.id.profession);
            dist = (TextView) itemView.findViewById(R.id.dist);
            progrs = (ProgressBar) itemView.findViewById(R.id.progresBar) ;
            abt1 = (TextView) itemView.findViewById(R.id.abt1);
            abt2 = (TextView) itemView.findViewById(R.id.abt2);
            abt3 = (TextView) itemView.findViewById(R.id.abt3);
            abt4 = (TextView) itemView.findViewById(R.id.abt4);
            bubble2_layout = (LinearLayout) itemView.findViewById(R.id.bubble2_layout);
            bubble2_txt = (TextView) itemView.findViewById(R.id.bubble2_txt);
        }

    }

}