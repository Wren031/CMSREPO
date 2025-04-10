package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.OfficialAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.OfficialViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class OfficalComponents {

    RecyclerView recyclerView;
    List<OfficialViewModel> model;
    OfficialAdapter adapter;
    Context context;

    public OfficalComponents(Context context, View parentView){
        this.context = context;
        this.model = new ArrayList<>();

        recyclerView = parentView.findViewById(R.id._officialItem);
        adapter = new OfficialAdapter(model);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
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
        ResidentsComponents residentsComponents = new ResidentsComponents(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();

        for (ResidentsViewModel resident : residents) {
            newList.add(new OfficialViewModel(
                    1,
                    resident,
                    "SK, Kagawad",
                    "May, 5, 2018",
                    "Feb 1, 2025"
            ));
        }
        return newList;
    }

}
