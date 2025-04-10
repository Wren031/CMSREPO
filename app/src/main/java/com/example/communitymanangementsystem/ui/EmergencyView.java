package com.example.communitymanangementsystem.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.EmergencyComponents;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ServiceComponents;
import com.example.communitymanangementsystem.model.EmergencyViewModel;
import com.example.communitymanangementsystem.model.ServiceViewModel;

import java.util.List;

public class EmergencyView extends AppCompatActivity {
    private NavbarListener navbarListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emergency_view);
        navbarListener = new NavbarListener(this);
        EmergencyComponents serviceComponents = new EmergencyComponents(this, findViewById(R.id._emergencyItem));
        List<EmergencyViewModel> newServices = serviceComponents.emergencyList();
        serviceComponents.updateEmergencyList(newServices);


    }
}