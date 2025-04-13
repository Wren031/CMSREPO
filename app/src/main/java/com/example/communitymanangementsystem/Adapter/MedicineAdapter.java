package com.example.communitymanangementsystem.Adapter;

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
import com.example.communitymanangementsystem.components.buttonListerner.view_model.MedicineController;
import com.example.communitymanangementsystem.model.MedicineViewModel;
import com.example.communitymanangementsystem.ui.content.medicine.MedicineContent;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {
    private List<MedicineViewModel> data;
    private Context context;

    public MedicineAdapter(Context context, List<MedicineViewModel> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MedicineAdapter.MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._medicine_layout_item, parent, false);
        return new MedicineAdapter.MedicineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.MedicineViewHolder holder, int position) {
        MedicineViewModel model = data.get(position);
        holder.name.setText(model.getName());
        holder.stock.setText(String.valueOf(model.getStock()));
        Glide.with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.image);
        holder.isFavorite = false;
        holder.favorite.setOnClickListener(v -> {
            if (holder.isFavorite) {
                holder.favorite.setImageResource(R.drawable.baseline_favorite_border_24);
                holder.isFavorite = false;
            } else {
                holder.favorite.setImageResource(R.drawable.baseline_favorite_24);
                holder.isFavorite = true;
            }
        });
        holder.itemView.setOnClickListener( v -> {
            Intent intent = new Intent(context, MedicineContent.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MedicineViewHolder extends RecyclerView.ViewHolder {
        public boolean isFavorite;
        TextView name, stock;
        ImageView favorite, addIcon, image;
        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id._medcineName);
            this.stock = itemView.findViewById(R.id._stock);
            this.image = itemView.findViewById(R.id._image);
            this.favorite = itemView.findViewById(R.id._addTofavoraite);
            this.addIcon = itemView.findViewById(R.id._addIcon);
        }
    }
}
