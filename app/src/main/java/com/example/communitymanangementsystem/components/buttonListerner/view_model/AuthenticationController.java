package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import com.example.communitymanangementsystem.model.AuthenticationViewModel;

import java.util.List;

public class AuthenticationController {

    private List<AuthenticationViewModel> data;

    public AuthenticationController(List<AuthenticationViewModel> data) {
        this.data = data;
    }

    public boolean onLogin(String inputUsername, String inputPassword) {
        for (AuthenticationViewModel user : data) {
            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }

}
