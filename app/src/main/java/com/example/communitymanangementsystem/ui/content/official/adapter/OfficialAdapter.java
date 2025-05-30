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

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.official.model.OfficialViewModel;
import com.example.communitymanangementsystem.ui.content.official.ui.OfficialContentView;

import java.util.List;

public class OfficialAdapter extends RecyclerView.Adapter<OfficialAdapter.OffcialViewHolder> {
    private List<OfficialViewModel> data;
    private Context context;

    public OfficialAdapter(Context context, List<OfficialViewModel> data){
        this.context = context;
    this.data = data;
    }

    @NonNull
    @Override
    public OfficialAdapter.OffcialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_official_item, parent, false);
        return new OfficialAdapter.OffcialViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficialAdapter.OffcialViewHolder holder, int position) {
        OfficialViewModel model = data.get(position);
        holder.name.setText(model.getResidents().getFullName());
        holder.possition.setText(model.getPossition());
        holder.age.setText(model.getResidents().getAge());
        holder.btn.setOnClickListener(v -> {
            Intent intent = new Intent(context, OfficialContentView.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class OffcialViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView possition;
        ImageView image;
        ImageView status;
        TextView age;
        TextView btn;
        public OffcialViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id._nameOfficial);
            this.possition = itemView.findViewById(R.id._namePossition);
            this.image = itemView.findViewById(R.id._imageOfficial);
            this.status = itemView.findViewById(R.id._status_iconOfficial);
            this.age = itemView.findViewById(R.id._ageOfficial);
            this.btn = itemView.findViewById(R.id._viewBtn);
        }
    }
}
