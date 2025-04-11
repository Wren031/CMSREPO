package com.example.communitymanangementsystem.components.buttonListerner.listener;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.DashboardView;
import com.example.communitymanangementsystem.ui.MessageView;
import com.example.communitymanangementsystem.ui.ProfileView;

public class NavbarListener {

    private Activity activity;
    private ImageView home, message, settings, profile;

    public NavbarListener(Activity activity) {
        this.activity = activity;

        home = activity.findViewById(R.id.home_btn_image);
        message = activity.findViewById(R.id._messageBtn);
        settings = activity.findViewById(R.id.settings_btn_image);
        profile = activity.findViewById(R.id.profile_btn_image);
        setListeners();
    }

    private void setListeners() {
        profile.setOnClickListener(v ->{
            Intent i = new Intent(activity, ProfileView.class);
            activity.startActivity(i);
        });
        home.setOnClickListener(v -> {
            Intent i = new Intent(activity, DashboardView.class);
            activity.startActivity(i);
        });
        message.setOnClickListener(v -> {
            Intent i = new Intent(activity, MessageView.class);
            activity.startActivity(i);
        });

    }
}
