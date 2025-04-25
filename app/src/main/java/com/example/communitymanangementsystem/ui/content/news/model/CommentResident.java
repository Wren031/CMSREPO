package com.example.communitymanangementsystem.ui.content.news.model;

import com.example.communitymanangementsystem.model.ResidentsViewModel;

public class CommentResident {

    int commentId;
    ResidentsViewModel resident;
    String comment;
    String createAt;

    public CommentResident(int commentId, ResidentsViewModel resident, String comment, String createAt) {
        this.commentId = commentId;
        this.resident = resident;
        this.comment = comment;
        this.createAt = createAt;
    }

    public int getCommentId() {
        return commentId;
    }

    public ResidentsViewModel getResident() {
        return resident;
    }

    public String getComment() {
        return comment;
    }

    public String getCreateAt() {
        return createAt;
    }
}
