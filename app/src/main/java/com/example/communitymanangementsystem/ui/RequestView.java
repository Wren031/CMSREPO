package com.example.communitymanangementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

public class RequestView extends AppCompatActivity {
    private NavbarListener navbarListener;
    private RelativeLayout medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_view);
        navbarListener = new NavbarListener(this);

        this.medicine = findViewById(R.id._request_medicine);

        medicine.setOnClickListener(v ->{
            Intent i = new Intent(RequestView.this, MedicineView.class);
            startActivity(i);
        });



    }
}