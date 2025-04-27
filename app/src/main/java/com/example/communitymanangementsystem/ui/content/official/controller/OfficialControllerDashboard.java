package com.example.communitymanangementsystem.ui.content.official.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ResidentsController;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.ui.content.official.adapter.OfficialDashboardAdapter;
import com.example.communitymanangementsystem.ui.content.official.model.OfficialViewModel;

import java.util.ArrayList;
import java.util.List;

public class OfficialControllerDashboard {

    private RecyclerView recyclerView;
    private List<OfficialViewModel> model;
    private OfficialDashboardAdapter adapter;
    private Handler scrollHandler;
    private Runnable scrollRunnable;
    private int scrollSpeed = 5;

    public OfficialControllerDashboard(Context context, View parentView) {
        model = new ArrayList<>();
        recyclerView = parentView.findViewById(R.id._officialItemView);

        adapter = new OfficialDashboardAdapter(context, model);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        autoScrollRecyclerView(layoutManager);
    }

    private void autoScrollRecyclerView(LinearLayoutManager layoutManager) {
        scrollHandler = new Handler();
        scrollRunnable = new Runnable() {
            @Override
            public void run() {
                int totalItemCount = adapter.getItemCount();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

                if (lastVisibleItemPosition < totalItemCount - 1) {
                    recyclerView.smoothScrollBy(scrollSpeed, 0);
                } else {
                    recyclerView.scrollToPosition(0);
                }

                scrollHandler.postDelayed(this, 50);
            }
        };
        scrollHandler.postDelayed(scrollRunnable, 500);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateOfficialList(List<OfficialViewModel> list) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            model.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    public List<OfficialViewModel> officialList() {
        List<OfficialViewModel> newList = new ArrayList<>();
        ResidentsController residentsComponents = new ResidentsController(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();

        for (ResidentsViewModel resident : residents) {
            newList.add(new OfficialViewModel(
                    1,
                    resident,
                    "SK, Kagawad",
                    "May 5, 2018",
                    "Feb 1, 2025"
            ));
        }
        return newList;
    }

}
