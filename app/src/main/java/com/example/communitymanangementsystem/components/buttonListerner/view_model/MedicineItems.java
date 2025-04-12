package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.MedicineAdapter;
import com.example.communitymanangementsystem.Adapter.MedicineCategoryAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.AuthenticationViewModel;
import com.example.communitymanangementsystem.model.MedicineViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.model.category_view_model.MedicineCategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MedicineItems {

    private RecyclerView recyclerView;
    private List<MedicineViewModel> model;
    private MedicineAdapter adapter;

    public MedicineItems(Context context, View parentView) {
        model = new ArrayList<>();
        recyclerView = parentView.findViewById(R.id._medicineItems);
        adapter = new MedicineAdapter(model);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateMedicineList(List<MedicineViewModel> newServiceList) {
        if (newServiceList != null && !newServiceList.isEmpty()) {
            model.clear();
            model.addAll(newServiceList);
            adapter.notifyDataSetChanged();
        }
    }

    public List<MedicineViewModel> fetchMedicineList() {
        MedicineCategoryViewModel category = new MedicineCategoryViewModel(1, "Vitamins", "Sep 2, 2005");
        List<MedicineViewModel> newList = new ArrayList<>();
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.covid, "Monday", "Biogesec"));
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.amoxicillin, "Monday", "Biogesec"));
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.covid, "Monday", "Biogesec"));
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.amoxicillin, "Monday", "Biogesec"));
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.covid, "Monday", "Biogesec"));
        newList.add(new MedicineViewModel(1, category, 25, "Feb 1, 2045", "Nov 30, 2045", R.drawable.amoxicillin, "Monday", "Biogesec"));
        return newList;
    }

}
