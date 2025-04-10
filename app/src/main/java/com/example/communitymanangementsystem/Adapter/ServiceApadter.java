package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ServiceViewModel;

import java.util.List;

public class ServiceApadter extends RecyclerView.Adapter<ServiceApadter.ServiceViewHolder> {
    private List<ServiceViewModel> data;

    public ServiceApadter(List<ServiceViewModel> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ServiceApadter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._service_layout_item, parent, false);
        return new ServiceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceApadter.ServiceViewHolder holder, int position) {
        ServiceViewModel model = data.get(position);
        holder.text.setText(model.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id._image);
            text = itemView.findViewById(R.id._title_id);

        }
    }
}
