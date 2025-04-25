package com.example.communitymanangementsystem.ui.content.news.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

public class NewsViewContent extends AppCompatActivity {
    private NavbarListener navbarListener;
    private ImageView likes, comment;
    private Boolean isToLike;
    private TextView totalLikes;

    private int totalLikesInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_view_content);

        navbarListener = new NavbarListener(this);
        this.comment = findViewById(R.id._commentID);

        this.comment.setOnClickListener(v ->{
            Intent i = new Intent(NewsViewContent.this, NewsCommentView.class);
            startActivity(i);
        });

        this.likes = findViewById(R.id._getLikes);
        this.totalLikes = findViewById(R.id._totalLikes);
        try {
            totalLikesInt = Integer.parseInt(totalLikes.getText().toString());
        } catch (NumberFormatException e) {
            totalLikesInt = 0;
        }

        this.isToLike = false;

        this.likes.setOnClickListener(v -> {
            if (this.isToLike) {
                likes.setImageResource(R.drawable.baseline_thumb_up_off_alt_24);
                totalLikesInt--;
                if (totalLikesInt < 0) totalLikesInt = 0;
                isToLike = false;
            } else {
                likes.setImageResource(R.drawable.baseline_thumb_up_24);
                totalLikesInt++;
                isToLike = true;
            }
            totalLikes.setText(String.valueOf(totalLikesInt + " Likes"));
        });

    }
}
