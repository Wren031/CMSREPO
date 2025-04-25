package com.example.communitymanangementsystem.ui.content.news.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.ui.content.news.adapter.CommentResidentAdapter;
import com.example.communitymanangementsystem.ui.content.news.controller.CommentController;
import com.example.communitymanangementsystem.ui.content.news.model.CommentResident;

import java.util.List;

public class NewsCommentView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommentResidentAdapter adapter;
    private CommentController commentController;
    private NavbarListener navbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_comment_view);

        recyclerView = findViewById(R.id._newsComment);
        navbarListener = new NavbarListener(this);

        commentController = new CommentController();

        ResidentsViewModel residentModel = new ResidentsViewModel(
                1, "Juan", "Dela", "Cruz", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01",R.drawable.daniel
        );

        commentController.addComment(1, residentModel, "Bugok man maong nasunog ", "2025-04-13");
        commentController.addComment(1, residentModel, "Gaba ", "2025-04-13");

        List<CommentResident> comments = commentController.getAllComments();

        adapter = new CommentResidentAdapter(comments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
