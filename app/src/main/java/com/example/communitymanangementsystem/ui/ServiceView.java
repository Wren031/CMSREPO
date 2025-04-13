package com.example.communitymanangementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.services.RequestBarangayClearance;

public class ServiceView extends AppCompatActivity {
    private NavbarListener navbarListener;
    private RelativeLayout clearance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_view);
        navbarListener = new NavbarListener(this);
        this.clearance = findViewById(R.id.clearance);

        this.clearance.setOnClickListener(v ->{
            Intent i = new Intent(ServiceView.this, RequestBarangayClearance.class);
            startActivity(i);
        });

    }
}