package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.NewsAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.LearnMoreListener;
import com.example.communitymanangementsystem.ui.content.news.ui.NewsViewContent;

import java.util.ArrayList;
import java.util.List;

public class NewsController implements LearnMoreListener {

    private RecyclerView newsRecycleView;
    private List<NewsViewModel> list_news;
    private NewsAdapter newsAdapter;
    private Context context;
    private Handler handler;
    private int currentNewsIndex = 0;

    public NewsController(Context context, View parentView) {
        this.context = context;
        list_news = new ArrayList<>();

        newsRecycleView = parentView.findViewById(R.id._newsItem);
        newsAdapter = new NewsAdapter(list_news, this);
        newsRecycleView.setHasFixedSize(true);
        newsRecycleView.setAdapter(newsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        newsRecycleView.setLayoutManager(layoutManager);

        handler = new Handler();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateNewsList(List<NewsViewModel> list) {
        if (list != null && !list.isEmpty()) {
            list_news.clear();
            list_news.addAll(list);
            newsAdapter.notifyDataSetChanged();
        }
    }

    public List<NewsViewModel> fetchNewNewsList() {
        List<NewsViewModel> newList = new ArrayList<>();
        newList.add(new NewsViewModel(1, "Jan 31, 2025", "Something Accident",  R.drawable.ayuda));
        newList.add(new NewsViewModel(2, "Feb 1, 2025", "Another Accident", R.drawable.covid));
        newList.add(new NewsViewModel(3, "Feb 2, 2025", "Yet Another Accident", R.drawable.medicine));
        newList.add(new NewsViewModel(4, "Mar 3, 2025", "Important Announcement", R.drawable.reservation));
        return newList;
    }

    @Override
    public void onLearnMoreListener(NewsViewModel model) {
        Intent intent = new Intent(context, NewsViewContent.class);
        context.startActivity(intent);
    }

    public void startAutoNextNews() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentNewsIndex < list_news.size() - 1) {
                    currentNewsIndex++;
                } else {
                    currentNewsIndex = 0;
                }
                newsRecycleView.smoothScrollToPosition(currentNewsIndex);
                handler.postDelayed(this, 5000);
            }
        }, 5000);
    }
}
