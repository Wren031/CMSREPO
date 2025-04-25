package com.example.communitymanangementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.accountInformation.VerifyAccountView;

public class ProfileView extends AppCompatActivity {
    private NavbarListener navbarListener;

    private TextView btnEditProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_view);
        navbarListener = new NavbarListener(this);
        btnEditProfile = findViewById(R.id._editProfileBtn);

        btnEditProfile.setOnClickListener(v ->{
            Intent i = new Intent(ProfileView.this, VerifyAccountView.class);
            startActivity(i);
        });

    }
}