package com.example.communitymanangementsystem.ui.content.family.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.family.controller.FamilyMemberController;
import com.example.communitymanangementsystem.ui.content.family.model.FamilyMemberViewModel;

import java.util.List;

public class FamilyMemberView extends AppCompatActivity {
    private NavbarListener navbarListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_family_member_view);
        navbarListener = new NavbarListener(this);


        FamilyMemberController components = new FamilyMemberController(this, findViewById(R.id._familyItem));
        List<FamilyMemberViewModel> service = components.addData();
        components.updateList(service);

    }
}