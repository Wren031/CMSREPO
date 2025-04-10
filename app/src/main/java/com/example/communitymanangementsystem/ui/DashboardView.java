package com.example.communitymanangementsystem.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.model.ServiceViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.NewsComponents;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NewsListener;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ServiceComponents;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ServiceListener;

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

        navbarListener = new NavbarListener(this);

        serviceListener = new ServiceListener(this);

        // display service data
        ServiceComponents serviceComponents = new ServiceComponents(this, findViewById(R.id._serviceView));
        List<ServiceViewModel> newServices = serviceComponents.fetchNewServiceList();
        serviceComponents.updateServiceList(newServices);

        // display news data
        NewsComponents newsComponents = new NewsComponents(this, findViewById(R.id._newsItem));
        List<NewsViewModel> newNews = newsComponents.fetchNewNewsList();
        newsComponents.updateNewsList(newNews);

    }
}