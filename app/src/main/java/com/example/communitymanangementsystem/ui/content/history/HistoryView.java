package com.example.communitymanangementsystem.ui.content.history;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.HistoryController;
import com.example.communitymanangementsystem.model.HistoryViewModel;
import com.example.communitymanangementsystem.ui.content.history.fragments.adapter.FragmentsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class HistoryView extends AppCompatActivity {

    private NavbarListener navbarListener;

    private TabLayout tab;
    private ViewPager2 viewPager2;
    private FragmentsAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_view);




        navbarListener = new NavbarListener(this);

        tab = findViewById(R.id._tab_layout);
        viewPager2 = findViewById(R.id._view_payer);
        adapter = new FragmentsAdapter(this);
        viewPager2.setAdapter(adapter);


        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}