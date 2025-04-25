package com.example.communitymanangementsystem.model;

public class NewsViewModel {

    int imageId;
    int image;
    String text;
    String date;
    public NewsViewModel(int imageId, String date, String text, int image) {
        this.imageId = imageId;
        this.date = date;
        this.text = text;
        this.image = image;
    }

    public int getImageId() {
        return imageId;
    }

    public int getImage() {
        return image;
    }


    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

}
