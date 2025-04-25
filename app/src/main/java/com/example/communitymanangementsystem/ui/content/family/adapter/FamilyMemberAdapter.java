package com.example.communitymanangementsystem.ui.content.family.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.family.model.FamilyMemberViewModel;

import java.util.List;

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.FamilyMemberViewHolder> {
    private List<FamilyMemberViewModel> data;

    public FamilyMemberAdapter(List<FamilyMemberViewModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public FamilyMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout._layout_family_item, parent, false);
        return new FamilyMemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyMemberViewHolder holder, int position) {
        FamilyMemberViewModel model = data.get(position);
        holder.possition.setText(model.getType());
        holder.name.setText(model.getResidentsViewModel().getFullName());
        holder.number.setText(model.getResidentsViewModel().getContactNumber());
        holder.gender.setText(model.getResidentsViewModel().getGender());
        holder.status.setText(model.getResidentsViewModel().getStatus());
        holder.btn.setOnClickListener( v -> {

        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class FamilyMemberViewHolder extends RecyclerView.ViewHolder {

        TextView possition, name, number, gender, status, btn;

        public FamilyMemberViewHolder(@NonNull View itemView) {
            super(itemView);

            this.possition = itemView.findViewById(R.id._namePossition);
            this.name = itemView.findViewById(R.id._nameFamily);
            this.number = itemView.findViewById(R.id._contactFamily);
            this.gender = itemView.findViewById(R.id._genderFamily);
            this.status = itemView.findViewById(R.id._statusFamily);
            this.btn = itemView.findViewById(R.id._viewBtn);

        }
    }
}
