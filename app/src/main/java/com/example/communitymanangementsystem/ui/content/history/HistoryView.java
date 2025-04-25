package com.example.communitymanangementsystem.ui.content.history;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.content.history.fragments.adapter.FragmentsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HistoryView extends AppCompatActivity {

    private NavbarListener navbarListener;

    private TabLayout tab;
    private ViewPager2 viewPager2;
    private FragmentsAdapter adapter;
    private ImageView filterBtn, settings;
    private RelativeLayout filterLayout;
    private TextView cerificate, reservation, medicine, equipment, result;
    private List<String> selectedItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_view);

        this.cerificate = findViewById(R.id._certificateBtn);
        this.reservation = findViewById(R.id._reservationBtn);
        this.medicine = findViewById(R.id._medicineBtn);
        this.equipment = findViewById(R.id._equipmentBtn);
        this.result = findViewById(R.id._resultBtn);

        int[] ids = {R.id._certificateBtn, R.id._reservationBtn, R.id._medicineBtn, R.id._equipmentBtn};

        for (int id : ids) {
            TextView button = findViewById(id);
            button.setOnClickListener(v -> {
                TextView clicked = (TextView) v;
                result.setVisibility(View.VISIBLE);
                result.setText(clicked.getText().toString());
            });
        }

        navbarListener = new NavbarListener(this);

        tab = findViewById(R.id._tab_layout);
        viewPager2 = findViewById(R.id._view_payer);
        adapter = new FragmentsAdapter(this);
        viewPager2.setAdapter(adapter);

        this.filterBtn = findViewById(R.id._filter);
        this.filterLayout = findViewById(R.id._filterLayout);
        this.settings = findViewById(R.id._settingsIcon);

        this.filterBtn.setOnClickListener(v -> {
            if (filterLayout.getVisibility() == View.VISIBLE) {
                filterLayout.animate()
                        .alpha(0f)
                        .setDuration(300)
                        .withEndAction(() -> filterLayout.setVisibility(View.GONE))
                        .start();
                settings.animate().cancel();

            } else {
                filterLayout.setAlpha(0f);
                filterLayout.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(settings, "rotation", 0f, 360f);
                objectAnimator.setDuration(1000);
                objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.start();

                filterLayout.animate()
                        .alpha(1f)
                        .setDuration(300)
                        .start();
            }
        });


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