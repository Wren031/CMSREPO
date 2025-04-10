package com.example.communitymanangementsystem.model;

public class ServiceViewModel {
    int serviceId;
    int imageUrl;
    String title;

    public ServiceViewModel(int serviceId, int imageUrl, String title) {
        this.serviceId = serviceId;
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return imageUrl;  // Return the image URL or path
    }

    public int getServiceId() {
        return serviceId;
    }
}
