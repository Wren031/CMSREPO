package com.example.communitymanangementsystem.model;

public class ReservationViewModel {
    int reservationID;
    String name;
    String availability;
    int image;

    public ReservationViewModel(int reservationID, String name, String availability, int image) {
        this.reservationID = reservationID;
        this.name = name;
        this.availability = availability;
        this.image = image;
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public int getImage() {
        return image;
    }
}
