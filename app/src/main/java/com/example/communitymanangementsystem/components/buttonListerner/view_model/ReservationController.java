package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.ReservationAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ReservationViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.ReservationListener;
import com.example.communitymanangementsystem.ui.content.reservation.ReservationRequest;

import java.util.ArrayList;
import java.util.List;

public class ReservationController implements ReservationListener {

    RecyclerView recyclerView;
    List<ReservationViewModel> model;
    ReservationAdapter adapter;
    Context context;

    public ReservationController(Context context, View parentView){
        this.context = context;
        this.model = new ArrayList<>();

        recyclerView = parentView.findViewById(R.id._reservationItem);
        adapter = new ReservationAdapter(model,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateResevationList(List<ReservationViewModel> list) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            model.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    public List<ReservationViewModel> reservationList() {
        List<ReservationViewModel> newList = new ArrayList<>();
        newList.add(new ReservationViewModel(1, "Plaza", "Available", R.drawable.plaza_image));
        newList.add(new ReservationViewModel(1, "Gym", "Available", R.drawable.plaza_image));
        return newList;
    }


    @Override
    public void onReservationListener(ReservationViewModel model) {
        Intent intent = new Intent(context, ReservationRequest.class);
        context.startActivity(intent);
    }
}
