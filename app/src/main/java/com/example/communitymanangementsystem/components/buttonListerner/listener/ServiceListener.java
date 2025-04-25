package com.example.communitymanangementsystem.components.buttonListerner.listener;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.emergency.EmergencyView;
import com.example.communitymanangementsystem.ui.content.family.ui.FamilyMemberView;
import com.example.communitymanangementsystem.ui.content.history.HistoryView;
import com.example.communitymanangementsystem.ui.content.news.ui.NewsView;
import com.example.communitymanangementsystem.ui.content.official.ui.OfficialView;
import com.example.communitymanangementsystem.ui.RequestView;
import com.example.communitymanangementsystem.ui.ReservationView;
import com.example.communitymanangementsystem.ui.ServiceView;
import com.example.communitymanangementsystem.ui.VerifyAccountView;

public class ServiceListener {
    private Activity activity;
    private TextView serviceView, verifyText;

    private ImageView newsViewBtn, servicesBtn, requestBtn, reservationBtn, historyBtn, emergenyBtn, officalBtn, familyBtn;

    public ServiceListener(Activity activity){
        this.activity = activity;
        this.serviceView = activity.findViewById(R.id.view_all);
        this.verifyText = activity.findViewById(R.id._verifyAccountBtn);
        this.newsViewBtn = activity.findViewById(R.id.news_view);
        this.servicesBtn = activity.findViewById(R.id.service_view);
        this.requestBtn = activity.findViewById(R.id.request_view);
        this.reservationBtn = activity.findViewById(R.id.reservation_view);
        this.historyBtn = activity.findViewById(R.id.history_view);
        this.emergenyBtn = activity.findViewById(R.id.emergency_view);
        this.officalBtn = activity.findViewById(R.id.barangayOfficial_view);
        this.familyBtn = activity.findViewById(R.id.family_view);
        setListeners();
    }

    private void setListeners() {
        familyBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, FamilyMemberView.class);
            activity.startActivity(i);
        });
        officalBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, OfficialView.class);
            activity.startActivity(i);
        });
        emergenyBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, EmergencyView.class);
            activity.startActivity(i);
        });
        historyBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, HistoryView.class);
            activity.startActivity(i);
        });
        serviceView.setOnClickListener(v -> {
            Intent i = new Intent(activity, ServiceView.class);
            activity.startActivity(i);
        });
        verifyText.setOnClickListener(v -> {
            Intent i = new Intent(activity, VerifyAccountView.class);
            activity.startActivity(i);
        });
        newsViewBtn.setOnClickListener(v -> {
            Intent i = new Intent(activity, NewsView.class);
            activity.startActivity(i);
        });
        servicesBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, ServiceView.class);
            activity.startActivity(i);
        });
        requestBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, RequestView.class);
            activity.startActivity(i);
        });
        reservationBtn.setOnClickListener(v ->{
            Intent i = new Intent(activity, ReservationView.class);
            activity.startActivity(i);
        });
    }
}
