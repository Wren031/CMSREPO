package com.example.communitymanangementsystem.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ReservationViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ReservationComponents;

import java.util.List;

public class ReservationView extends AppCompatActivity {

    private NavbarListener navbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reservation_view);

        navbarListener = new NavbarListener(this);

        ReservationComponents com = new ReservationComponents(this, findViewById(R.id._reservationItem));
        List<ReservationViewModel> modelList = com.reservationList();
        com.updateResevationList(modelList);

    }
}