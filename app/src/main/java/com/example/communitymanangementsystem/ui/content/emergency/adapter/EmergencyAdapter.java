package com.example.communitymanangementsystem.ui.content.emergency.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.EmergencyListener;
import com.example.communitymanangementsystem.ui.content.emergency.model.EmergencyViewModel;

import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder> {
    private List<EmergencyViewModel> data;
    private EmergencyListener listener;

    public EmergencyAdapter(List<EmergencyViewModel> data, EmergencyListener listener){
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmergencyAdapter.EmergencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_emergency_item, parent, false);
        return new EmergencyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmergencyAdapter.EmergencyViewHolder holder, int position) {
        EmergencyViewModel model = data.get(position);
        holder.name.setText(model.getName());
        holder.number.setText(model.getNumber());
        Glide.with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.image);
        holder.itemView.setOnClickListener(v ->{
            if (listener != null){
                listener.onCall(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class EmergencyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView number;
        ImageView image;

        public EmergencyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id._emergencyName);
            number = itemView.findViewById(R.id._emergencyNumber);
            image = itemView.findViewById(R.id._emergencyImage);
        }
    }
}

