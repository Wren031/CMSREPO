package com.example.communitymanangementsystem.ui.content.news.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.ui.content.news.model.CommentResident;

import java.util.List;

public class CommentResidentAdapter extends RecyclerView.Adapter<CommentResidentAdapter.CommentViewHolder> {

    private List<CommentResident> commentList;

    public CommentResidentAdapter(List<CommentResident> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout._item_comment_resident, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        CommentResident comment = commentList.get(position);
        holder.residentName.setText(comment.getResident().getFullName());
        holder.commentText.setText(comment.getComment());
        holder.commentDate.setText(comment.getCreateAt());
        Glide.with(holder.itemView.getContext())
                .load(comment.getResident().getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView residentName, commentText, commentDate;
        ImageView image;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            residentName = itemView.findViewById(R.id.resident_name);
            commentText = itemView.findViewById(R.id.comment_text);
            commentDate = itemView.findViewById(R.id.comment_date);
            image = itemView.findViewById(R.id._image);
        }
    }
}
