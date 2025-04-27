package com.example.communitymanangementsystem.ui.content.official.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.components.buttonListerner.view_model.ResidentsController;
import com.example.communitymanangementsystem.ui.content.official.adapter.OfficialAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.official.model.OfficialViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class OfficalController {

    RecyclerView recyclerView;
    List<OfficialViewModel> model;
    OfficialAdapter adapter;
    Context context;

    public OfficalController(Context context, View parentView){
        this.context = context;
        this.model = new ArrayList<>();

        recyclerView = parentView.findViewById(R.id._officialItem);
        adapter = new OfficialAdapter(context, model);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

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
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
            newList.add(new OfficialViewModel(
                    2,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
            newList.add(new OfficialViewModel(
                    3,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
            newList.add(new OfficialViewModel(
                    4,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
            newList.add(new OfficialViewModel(
                    5,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
            newList.add(new OfficialViewModel(
                    6,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
        }
        return newList;
    }

}
