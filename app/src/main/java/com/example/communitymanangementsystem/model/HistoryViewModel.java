package com.example.communitymanangementsystem.model;

public class HistoryViewModel {
    int certificationID;
    String history_name;
    String date;
    String status;
    ResidentsViewModel residents;
    String pick_up_date;

    public HistoryViewModel(int certificationID, String history_name, String date, String status, ResidentsViewModel residents, String pick_up_date) {
        this.certificationID = certificationID;
        this.history_name = history_name;
        this.date = date;
        this.status = status;
        this.residents = residents;
        this.pick_up_date = pick_up_date;
    }

    public int getCertificationID() {
        return certificationID;
    }

    public String getHistory_name() {
        return history_name;
    }

    public String getPick_up_date() {
        return pick_up_date;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public ResidentsViewModel getResidents() {
        return residents;
    }
}
