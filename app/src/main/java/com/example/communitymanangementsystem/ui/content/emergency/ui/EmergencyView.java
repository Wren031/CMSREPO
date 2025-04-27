package com.example.communitymanangementsystem.ui.content.emergency.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.emergency.controller.EmergencyController;
import com.example.communitymanangementsystem.ui.content.emergency.model.EmergencyViewModel;

import java.util.List;

public class EmergencyView extends AppCompatActivity {
    private NavbarListener navbarListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emergency_view);
        navbarListener = new NavbarListener(this);

        EmergencyController serviceComponents = new EmergencyController(this, findViewById(R.id._emergencyItem));
        List<EmergencyViewModel> newServices = serviceComponents.emergencyList();
        serviceComponents.updateEmergencyList(newServices);

    }
}