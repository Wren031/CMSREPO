package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.HistoryViewModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private List<HistoryViewModel> data;

    public HistoryAdapter(List<HistoryViewModel> data){
        this.data = data;
    }

    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_history_item, parent, false);
        return new HistoryAdapter.HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        HistoryViewModel model = data.get(position);
        holder.name.setText(model.getHistory_name());
        holder.date.setText(model.getDate());
        holder.pickUpdate.setText(model.getPick_up_date());
        holder.status.setText(model.getStatus());
        holder.itemView.setOnClickListener(v ->{

        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView date;
        private TextView pickUpdate;
        private TextView button;
        private TextView status;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id._historyName);
            this.date = itemView.findViewById(R.id._date);
            this.pickUpdate = itemView.findViewById(R.id._pickUpdate);
            this.status = itemView.findViewById(R.id._status);
            this.button = itemView.findViewById(R.id._viewBtn);
        }
    }
}
