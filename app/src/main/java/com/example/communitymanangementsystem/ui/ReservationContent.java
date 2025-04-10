package com.example.communitymanangementsystem.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

public class ReservationContent extends AppCompatActivity {
    private NavbarListener navbarListener;
    private TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reservation_content);

        submit = findViewById(R.id.sumbitBtn);

        navbarListener = new NavbarListener(this);


    }
}