package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.NewsViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.LearnMoreListener;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsViewModel> news;
    private LearnMoreListener listener;


    public NewsAdapter(List<NewsViewModel> news, LearnMoreListener listener){
        this.news = news;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_news_item, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsViewModel model = news.get(position);
        holder.text.setText(model.getText());
        holder.date.setText(model.getDate());

        holder.itemView.setOnClickListener( v -> {
            if(this.listener != null){
                this.listener.onLearnMoreListener(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        TextView date;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id._image);
            text = itemView.findViewById(R.id._text);
            date = itemView.findViewById(R.id._date);
        }
    }
}
