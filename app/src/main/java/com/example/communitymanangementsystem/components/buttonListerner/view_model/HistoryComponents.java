package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.HistoryAdapter;
import com.example.communitymanangementsystem.Adapter.NewsAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.HistoryViewModel;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.ui.NewsViewContent;

import java.util.ArrayList;
import java.util.List;

public class HistoryComponents {
    private List<ResidentsViewModel> data = new ArrayList<>();


    private RecyclerView newsRecycleView;
    private List<HistoryViewModel> model;
    private HistoryAdapter adapter;
    private Context context;

    public HistoryComponents(Context context, View parentView) {
        this.context = context;
        model = new ArrayList<>();

        newsRecycleView = parentView.findViewById(R.id._historyItem);
        adapter = new HistoryAdapter(model);
        newsRecycleView.setHasFixedSize(true);
        newsRecycleView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        newsRecycleView.setLayoutManager(layoutManager);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateNewsList(List<HistoryViewModel> list) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            model.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    public List<HistoryViewModel> fetchHistoryList() {
        List<HistoryViewModel> newList = new ArrayList<>();

        ResidentsComponents residentsComponents = new ResidentsComponents(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();

        for (ResidentsViewModel resident : residents) {
            newList.add(new HistoryViewModel(
                    1,
                    "Something Accident",
                    "Jan 31, 2025",
                    "Pending",
                    resident,
                    "Feb 1, 2025"
            ));
        }

        return newList;
    }


}
