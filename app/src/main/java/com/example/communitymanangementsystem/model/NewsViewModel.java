package com.example.communitymanangementsystem.model;

public class NewsViewModel {

    int imageId;
    String image;
    String text;
    String date;
    public NewsViewModel(int imageId, String date, String text, String image) {
        this.imageId = imageId;
        this.date = date;
        this.text = text;
        this.image = image;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImage() {
        return image;
    }


    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

}
