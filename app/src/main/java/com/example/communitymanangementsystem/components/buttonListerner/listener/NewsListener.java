package com.example.communitymanangementsystem.components.buttonListerner.listener;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.news.ui.NewsView;

public class NewsListener {

    private Activity activity;
    private TextView learnMore;

    public NewsListener(Activity activity) {
        this.activity = activity;
        this.learnMore = activity.findViewById(R.id.learnMore);

        setListeners();
    }

    private void setListeners() {
        learnMore.setOnClickListener(v -> {
            Intent i = new Intent(activity, NewsView.class);
            activity.startActivity(i);
        });
    }
}
