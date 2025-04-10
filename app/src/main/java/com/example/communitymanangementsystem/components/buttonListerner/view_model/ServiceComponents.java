package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ServiceViewModel;
import com.example.communitymanangementsystem.Adapter.ServiceApadter;

import java.util.ArrayList;
import java.util.List;

public class ServiceComponents {

    private RecyclerView serviceRecyclerView;
    private List<ServiceViewModel> listService;
    private ServiceApadter serviceAdapter;

    public ServiceComponents(Context context, View parentView) {
        listService = new ArrayList<>();
        serviceRecyclerView = parentView.findViewById(R.id._serviceView);

        serviceAdapter = new ServiceApadter(listService);

        serviceRecyclerView.setAdapter(serviceAdapter);
        serviceRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        serviceRecyclerView.setLayoutManager(layoutManager);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateServiceList(List<ServiceViewModel> newServiceList) {
        if (newServiceList != null && !newServiceList.isEmpty()) {
            listService.clear();
            listService.addAll(newServiceList);
            serviceAdapter.notifyDataSetChanged();
        }
    }

    public List<ServiceViewModel> fetchNewServiceList() {
        List<ServiceViewModel> newList = new ArrayList<>();
        newList.add(new ServiceViewModel(6, R.drawable.breaking_news, "New Service"));
        newList.add(new ServiceViewModel(7, R.drawable.news_image, "Another Service"));
        newList.add(new ServiceViewModel(6, R.drawable.login_image, "New Service"));
        newList.add(new ServiceViewModel(7, R.drawable.news, "Another Service"));
        newList.add(new ServiceViewModel(6, R.drawable.login_image, "New Service"));
        newList.add(new ServiceViewModel(7, R.drawable.official, "Another Service"));
        return newList;
    }
}
