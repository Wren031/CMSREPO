package com.example.communitymanangementsystem.ui.content.history.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.HistoryController;
import com.example.communitymanangementsystem.model.HistoryViewModel;

import java.util.List;


public class HomeFragments extends Fragment {
    private HistoryController controller;
    private List<HistoryViewModel> model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragments, container, false);

        this.controller = new HistoryController(getContext(), view);
        this.model = controller.fetchHistoryList();
        this.controller.updateNewsList(model);

        return view;


    }
}