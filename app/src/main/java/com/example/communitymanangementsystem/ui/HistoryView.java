package com.example.communitymanangementsystem.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.HistoryComponents;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ReservationComponents;
import com.example.communitymanangementsystem.model.HistoryViewModel;
import com.example.communitymanangementsystem.model.ReservationViewModel;

import java.util.List;

public class HistoryView extends AppCompatActivity {

    private NavbarListener navbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_view);

        navbarListener = new NavbarListener(this);

        HistoryComponents components = new HistoryComponents(this, findViewById(R.id._historyItem));
        List<HistoryViewModel> model = components.fetchHistoryList();
        components.updateNewsList(model);



    }
}