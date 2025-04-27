package com.example.communitymanangementsystem.ui.content.official.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.official.model.OfficialViewModel;
import com.example.communitymanangementsystem.ui.content.official.ui.OfficialContentView;

import java.util.List;

public class OfficialDashboardAdapter extends RecyclerView.Adapter<OfficialDashboardAdapter.OfficialViewHolder> {

    private List<OfficialViewModel> data;
    private Context context;

    public OfficialDashboardAdapter(Context context, List<OfficialViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public OfficialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._official_layout_item_dashboard, parent, false);
        return new OfficialViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficialViewHolder holder, int position) {
        OfficialViewModel model = data.get(position);

        if (model.getResidents() != null) {
            holder.name.setText(model.getResidents().getFullName());
            holder.posstion.setText(model.getPossition());
            Glide.with(holder.itemView.getContext())
                    .load(model.getResidents().getImage())

                    .into(holder.image);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, OfficialContentView.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }

    public static class OfficialViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, posstion;


        public OfficialViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id._name_id);
            posstion = itemView.findViewById(R.id._possition_id);
            image = itemView.findViewById(R.id._image);
        }
    }
}
