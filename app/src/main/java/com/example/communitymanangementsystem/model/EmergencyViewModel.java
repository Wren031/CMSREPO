package com.example.communitymanangementsystem.model;

public class EmergencyViewModel {
    int emergencyID;
    String name;
    int image;
    String number;

    public EmergencyViewModel(int emergencyID, String name, int image, String number) {
        this.emergencyID = emergencyID;
        this.name = name;
        this.image = image;
        this.number = number;
    }

    public int getEmergencyID() {
        return emergencyID;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getNumber() {
        return number;
    }
}
