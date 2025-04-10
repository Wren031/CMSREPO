package com.example.communitymanangementsystem.model;

public class AuthenticationViewModel {
    private int authenticationID;
    private ResidentsViewModel residents;
    private String username;
    private String password;

    public AuthenticationViewModel(int authenticationID, ResidentsViewModel residents, String username, String password) {
        this.authenticationID = authenticationID;
        this.residents = residents;
        this.username = username;
        this.password = password;
    }

    public int getAuthenticationID() {
        return authenticationID;
    }

    public ResidentsViewModel getResidents() {
        return residents;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
