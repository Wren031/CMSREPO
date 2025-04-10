package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.List;

public class ResidentsAdapter extends RecyclerView.Adapter<ResidentsAdapter.ResidentsViewHodler> {

    List<ResidentsViewModel> residents;
    private LayoutInflater mInflater;

    public ResidentsAdapter(List<ResidentsViewModel> residents){
        this.residents = residents;
    }

    @NonNull
    @Override
    public ResidentsAdapter.ResidentsViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentsAdapter.ResidentsViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ResidentsViewHodler extends RecyclerView.ViewHolder {
        public ResidentsViewHodler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
