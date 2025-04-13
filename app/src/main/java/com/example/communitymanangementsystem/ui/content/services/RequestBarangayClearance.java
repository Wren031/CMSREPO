package com.example.communitymanangementsystem.ui.content.services;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.DatePicker.DatePickerViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.services.view_model.ClearanceViewModel;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RequestBarangayClearance extends AppCompatActivity {
    private Spinner spinner;
    private ClearanceViewModel model;
    private TextView price, submit;
    private NavbarListener navbarListener;

    private DatePickerViewModel viewModel;
    private EditText startDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_barangay_clearance);
        this.price = findViewById(R.id._amount);
        this.submit = findViewById(R.id._submit);

        this.navbarListener = new NavbarListener(this);

        spinner = findViewById(R.id.purpose_id);
        this.model = new ClearanceViewModel(this, spinner, price);
        this.startDate = findViewById(R.id._pickUpdate);

        this.submit.setOnClickListener(v ->{
            new SweetAlertDialog(RequestBarangayClearance.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Success")
                    .setContentText("Your operation was successful!")
                    .setConfirmText("OK")
                    .show();
        });

        viewModel = new ViewModelProvider(this).get(DatePickerViewModel.class);
        startDate.setOnClickListener(v -> viewModel.pickDate(RequestBarangayClearance.this));
        viewModel.getSelectedDate().observe(this, date -> startDate.setText(date));

    }
}