package com.example.communitymanangementsystem.ui.content.family.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ResidentsController;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.ui.content.family.adapter.FamilyMemberAdapter;
import com.example.communitymanangementsystem.ui.content.family.model.FamilyMemberViewModel;

import java.util.ArrayList;
import java.util.List;

public class FamilyMemberController {

    private RecyclerView recyclerView;
    private FamilyMemberAdapter adapter;
    private Context context;
    private List<FamilyMemberViewModel> model;

    public FamilyMemberController(Context context, View view) {
        this.context = context;
        this.model = new ArrayList<>();
        this.recyclerView = view.findViewById(R.id._familyItem);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FamilyMemberAdapter(model);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<FamilyMemberViewModel> list) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            model.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    public List<FamilyMemberViewModel> addData(){
        ResidentsController residentsComponents = new ResidentsController(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();
        List<FamilyMemberViewModel> list = new ArrayList<>();

        if (!residents.isEmpty()) {
            ResidentsViewModel resident = residents.get(0);
            list.add(new FamilyMemberViewModel(1, "Family Head", resident));
            list.add(new FamilyMemberViewModel(2, "Daughter", resident));
            list.add(new FamilyMemberViewModel(3, "Daughter", resident));
        }
        return list;
    }

}
