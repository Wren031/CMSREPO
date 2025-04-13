package com.example.communitymanangementsystem.ui.content.services.view_model;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.communitymanangementsystem.ui.content.services.model.Clearance;

import java.util.ArrayList;
import java.util.List;

public class ClearanceViewModel extends ViewModel {
    private List<Clearance> data;
    private Spinner clearanceSpinner;
    private Context context;
    private TextView priceTextView;

    public ClearanceViewModel(Context context, Spinner clearanceSpinner, TextView priceTextView) {
        this.context = context;
        this.clearanceSpinner = clearanceSpinner;
        this.priceTextView = priceTextView;
        this.data = new ArrayList<>();

        setupClearanceData();
        setupSpinner();
        setupSpinnerListener();
    }

    private void setupClearanceData() {
        data.add(new Clearance(1, "Educational Assistance", 100.0));
        data.add(new Clearance(2, "Financial Assistance", 50.0));
    }

    private void setupSpinner() {
        List<String> clearanceNames = new ArrayList<>();
        for (Clearance c : data) {
            clearanceNames.add(c.getClearanceName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_item,
                clearanceNames
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clearanceSpinner.setAdapter(adapter);
    }

    private void setupSpinnerListener() {
        clearanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Clearance selectedClearance = data.get(position);
                double price = selectedClearance.getPrice();
                priceTextView.setText("₱ " + String.format("%.2f", price));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                priceTextView.setText("₱ 0.00");
            }
        });
    }
}
