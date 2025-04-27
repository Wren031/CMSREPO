package com.example.communitymanangementsystem.ui.content.medicine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.MedicineCategoryController;
import com.example.communitymanangementsystem.ui.content.medicine.controller.MedicineController;
import com.example.communitymanangementsystem.ui.content.medicine.model.MedicineViewModel;
import com.example.communitymanangementsystem.model.category_model.MedicineCategoryViewModel;
import com.example.communitymanangementsystem.ui.RequestView;

import java.util.List;

public class MedicineView extends AppCompatActivity {
    private ImageView backIcon;
    private NavbarListener navbarListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine_view);
        MedicineCategoryController com = new MedicineCategoryController(this, findViewById(R.id._categoryItem));
        List<MedicineCategoryViewModel> data = com.fetchMedicineCategoryList();
        com.updateMedCategoryList(data);

        this.backIcon = findViewById(R.id._arrow_back);

        navbarListener = new NavbarListener(this);

        MedicineController med = new MedicineController(this, findViewById(R.id._medicineItems));
        List<MedicineViewModel> med_data = med.fetchMedicineList();
        med.updateMedicineList(med_data);

        backIcon.setOnClickListener(v ->{
            Intent i = new Intent(MedicineView.this, RequestView.class);
        });

    }
}