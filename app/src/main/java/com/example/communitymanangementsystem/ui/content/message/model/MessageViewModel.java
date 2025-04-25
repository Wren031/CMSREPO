package com.example.communitymanangementsystem.ui.content.message.model;

import com.example.communitymanangementsystem.model.ResidentsViewModel;

public class MessageViewModel {

    int messageID;
    ResidentsViewModel residentID;
    String image;
    String time;
    String message;
    int quantity;


    public MessageViewModel(int messageID, ResidentsViewModel residentID, String image, String time, String message, int quantity) {
        this.messageID = messageID;
        this.residentID = residentID;
        this.image = image;
        this.time = time;
        this.message = message;
        this.quantity = quantity;
    }

    public int getMessageID() {
        return messageID;
    }

    public ResidentsViewModel getResidentID() {
        return residentID;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMessage(){
        return message;
    }
}
