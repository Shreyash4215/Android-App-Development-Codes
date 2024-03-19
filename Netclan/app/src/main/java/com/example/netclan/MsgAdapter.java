package com.example.netclan;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    private List<MsgDTO> msgDtoList = null;

    private Handler messageHandler = new Handler();
    public MsgAdapter(List<MsgDTO> msgDtoList) {
        this.msgDtoList = msgDtoList;
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        MsgDTO msgDto = this.msgDtoList.get(position);

        holder.bubble_layout.setVisibility(LinearLayout.VISIBLE);
        holder.bubble_txt.setText(msgDto.getMain());
        holder.location.setText(msgDto.getlocation());
        holder.profession.setText(msgDto.getprofession());
        holder.dist.setText(msgDto.getdist());
        holder.progrs.setProgress(msgDto.getprogrs());
        holder.abt1.setText(msgDto.getabt1());
        holder.abt2.setText(msgDto.getabt2());
        holder.abt3.setText(msgDto.getabt3());
        holder.abt4.setText(msgDto.getabt4());
        holder.bubble2_layout.setVisibility(LinearLayout.VISIBLE);
        holder.bubble2_txt.setText(msgDto.getSub());

    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerlayout, parent, false);
        return new MsgViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if(msgDtoList==null)
        {
            msgDtoList = new ArrayList<MsgDTO>();
        }
        return msgDtoList.size();
    }
}