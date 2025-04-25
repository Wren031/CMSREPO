package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.category_model.MedicineCategoryViewModel;

import java.util.List;

public class MedicineCategoryAdapter extends RecyclerView.Adapter<MedicineCategoryAdapter.MedicineCategoryViewHolder> {

    private List<MedicineCategoryViewModel> model;

    public MedicineCategoryAdapter(List<MedicineCategoryViewModel> model){
        this.model = model;
    }

    @NonNull
    @Override
    public MedicineCategoryAdapter.MedicineCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_medicine_category_item, parent, false);
        return new MedicineCategoryAdapter.MedicineCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineCategoryAdapter.MedicineCategoryViewHolder holder, int position) {
        MedicineCategoryViewModel i = model.get(position);
        holder.category.setText(i.getName());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class MedicineCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView category;
        public MedicineCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.category = itemView.findViewById(R.id._categoryName);
        }
    }
}
