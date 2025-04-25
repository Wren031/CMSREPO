package com.example.communitymanangementsystem.ui.dashboard;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.model.ServiceViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.NewsController;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NewsListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ServiceController;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ServiceListener;
import com.example.communitymanangementsystem.ui.dashboard.components.LoadingAnimationController;

import java.util.List;

public class DashboardView extends AppCompatActivity{

    private NavbarListener navbarListener;
    private ServiceListener serviceListener;
    private NewsListener newsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dashboard_view);

        this.navbarListener = new NavbarListener(this);

        serviceListener = new ServiceListener(this);
        LoadingAnimationController loadingController = new LoadingAnimationController(this, findViewById(R.id.loading_container));
        loadingController.startLoadingAnimation();


        // display service data
        ServiceController serviceComponents = new ServiceController(this, findViewById(R.id._serviceView));
        List<ServiceViewModel> newServices = serviceComponents.fetchNewServiceList();
        serviceComponents.updateServiceList(newServices);

        // display news data
        NewsController newsComponents = new NewsController(this, findViewById(R.id._newsItem));
        List<NewsViewModel> newNews = newsComponents.fetchNewNewsList();
        newsComponents.updateNewsList(newNews);
        newsComponents.startAutoNextNews();

    }
}