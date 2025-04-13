package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.MedicineCategoryAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.category_model.MedicineCategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MedicineCategoryController {

    private RecyclerView recyclerView;
    private List<MedicineCategoryViewModel> model;
    private MedicineCategoryAdapter adapter;

    public MedicineCategoryController(Context context, View parentView) {
        model = new ArrayList<>();
        recyclerView = parentView.findViewById(R.id._categoryItem);

        adapter = new MedicineCategoryAdapter(model);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateMedCategoryList(List<MedicineCategoryViewModel> newServiceList) {
        if (newServiceList != null && !newServiceList.isEmpty()) {
            model.clear();
            model.addAll(newServiceList);
            adapter.notifyDataSetChanged();
        }
    }

    public List<MedicineCategoryViewModel> fetchMedicineCategoryList() {
        List<MedicineCategoryViewModel> newList = new ArrayList<>();
        model.add(new MedicineCategoryViewModel(1, "Vitamins", "Jan, 31 2025"));
        model.add(new MedicineCategoryViewModel(1, "Anti Fungal", "Jan, 31 2025"));
        model.add(new MedicineCategoryViewModel(1, "Analgesics ", "Jan, 31 2025"));
        model.add(new MedicineCategoryViewModel(1, "Anti-diarrheal", "Jan, 31 2025"));
        return newList;
    }

}
