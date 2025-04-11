package com.example.communitymanangementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

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