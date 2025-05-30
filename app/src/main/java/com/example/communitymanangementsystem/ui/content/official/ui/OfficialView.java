package com.example.communitymanangementsystem.ui.content.official.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.official.controller.OfficalController;
import com.example.communitymanangementsystem.ui.content.official.model.OfficialViewModel;


import java.util.List;

public class OfficialView extends AppCompatActivity {
    private NavbarListener navbarListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_official_view);
        navbarListener = new NavbarListener(this);
        OfficalController components = new OfficalController(this, findViewById(R.id._officialItem));
        List<OfficialViewModel> model = components.officialList();
        components.updateOfficialList(model);

    }
}