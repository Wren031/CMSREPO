package com.example.communitymanangementsystem.ui.content.news.controller;

import com.example.communitymanangementsystem.ui.content.news.model.CommentResident;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class CommentController {
    private List<CommentResident> commentList;

    public CommentController() {
        this.commentList = new ArrayList<>();
    }

    public List<CommentResident> getAllComments() {
        return commentList;
    }

    public void addComment(int commentId, ResidentsViewModel resident, String comment, String createdAt) {
        CommentResident newComment = new CommentResident(commentId, resident, comment, createdAt);
        commentList.add(newComment);
    }

    public void removeCommentById(int commentId) {
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getCommentId() == commentId) {
                commentList.remove(i);
                break;
            }
        }
    }

    public void clearAllComments() {
        commentList.clear();
    }
}
