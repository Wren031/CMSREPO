package com.example.communitymanangementsystem.ui.content.emergency.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.ui.content.emergency.adapter.EmergencyAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.EmergencyListener;
import com.example.communitymanangementsystem.ui.content.emergency.model.EmergencyViewModel;
import com.example.communitymanangementsystem.ui.content.emergency.ui.EmergencyContent;

import java.util.ArrayList;
import java.util.List;

public class EmergencyController implements EmergencyListener {

    RecyclerView recyclerView;
    List<EmergencyViewModel> model;
    EmergencyAdapter adapter;
    Context context;

    public EmergencyController(Context context, View parentView){
        this.context = context;
        this.model = new ArrayList<>();

        recyclerView = parentView.findViewById(R.id._emergencyItem);
        adapter = new EmergencyAdapter(model, (EmergencyListener) this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateEmergencyList(List<EmergencyViewModel> list) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            model.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    public List<EmergencyViewModel> emergencyList() {
        List<EmergencyViewModel> newList = new ArrayList<>();
        newList.add(new EmergencyViewModel(1, "Pnp Police", R.drawable.police, "+639095540145"));
        newList.add(new EmergencyViewModel(1, "Valencia Hospital", R.drawable.police, "+639095540145"));
        newList.add(new EmergencyViewModel(1, "Pnp Police", R.drawable.police, "+639095540145"));
        return newList;
    }

    @Override
    public void onCall(EmergencyViewModel model) {
        Intent intent = new Intent(context, EmergencyContent.class);
        context.startActivity(intent);
    }
}
