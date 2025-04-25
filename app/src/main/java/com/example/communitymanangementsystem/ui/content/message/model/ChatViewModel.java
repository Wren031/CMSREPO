package com.example.communitymanangementsystem.ui.content.message.model;

import com.example.communitymanangementsystem.model.ResidentsViewModel;

public class ChatViewModel {

    private int chatID;
    private ResidentsViewModel sentTo;
    private ResidentsViewModel sentBy;
    private String dateTime;
    private String messageSent;

    public ChatViewModel(int chatID, ResidentsViewModel sentTo, ResidentsViewModel sentBy, String dateTime, String messageSent) {
        this.chatID = chatID;
        this.sentTo = sentTo;
        this.sentBy = sentBy;
        this.dateTime = dateTime;
        this.messageSent = messageSent;
    }

    public int getChatID() {
        return chatID;
    }

    public ResidentsViewModel getSentTo() {
        return sentTo;
    }

    public ResidentsViewModel getSentBy() {
        return sentBy;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getMessageSent() {
        return messageSent;
    }

}
