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
import com.example.communitymanangementsystem.model.ReservationViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.ReservationListener;
import java.util.List;


public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> {
    ReservationListener listener;
    private List<ReservationViewModel> data;

    public ReservationAdapter(List<ReservationViewModel> data, ReservationListener listener){
        this.data = data;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ReservationAdapter.ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_reservation_item, parent, false);
        return new ReservationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapter.ReservationViewHolder holder, int position) {
        ReservationViewModel model = data.get(position);
        Glide.with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.image);
        holder.gym.setText(model.getName());
        holder.availabilty.setText(model.getAvailability());
        holder.itemView.setOnClickListener(v ->{
            if (listener != null){
                this.listener.onReservationListener(data.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ReservationViewHolder extends RecyclerView.ViewHolder {
        TextView gym;
        ImageView image;
        TextView availabilty;

        public ReservationViewHolder(@NonNull View itemView) {
            super(itemView);
            gym = itemView.findViewById(R.id._gymName);
            image = itemView.findViewById(R.id._gymImage);
            availabilty = itemView.findViewById(R.id._gymAvailability);
        }
    }
}
