package com.example.communitymanangementsystem.ui.content.news.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.communitymanangementsystem.Adapter.NewsAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.LearnMoreListener;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.NewsController;

import java.util.ArrayList;
import java.util.List;

public class NewsView extends AppCompatActivity implements LearnMoreListener {

    private RecyclerView view;
    private List<NewsViewModel> model;
    private NewsAdapter adapter;

    private NavbarListener navbarListener;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_view);

        navbarListener = new NavbarListener(this);

        NewsController newsComponents = new NewsController(this, findViewById(R.id._newsItem));
        List<NewsViewModel> newNews = newsComponents.fetchNewNewsList();
        newsComponents.updateNewsList(newNews);



        model = new ArrayList<>();
        adapter = new NewsAdapter(model, (LearnMoreListener) this);
        view = findViewById(R.id._newsItem);


        model.add(new NewsViewModel(1, "Jan 31, 2025", "Something Accident", R.drawable.ayuda));
        model.add(new NewsViewModel(1, "Jan 31, 2025", "Something Accident", R.drawable.ayuda));

        view.setHasFixedSize(true);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void onLearnMoreListener(NewsViewModel model) {

    }
}