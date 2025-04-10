package com.example.communitymanangementsystem.model;

public class OfficialViewModel {

    int offcialID;
    ResidentsViewModel residents;
    String possition;
    String term_start;
    String term_end;

    public OfficialViewModel(int offcialID, ResidentsViewModel residents, String possition, String term_start, String term_end) {
        this.offcialID = offcialID;
        this.residents = residents;
        this.possition = possition;
        this.term_start = term_start;
        this.term_end = term_end;
    }

    public int getOffcialID() {
        return offcialID;
    }

    public ResidentsViewModel getResidents() {
        return residents;
    }

    public String getPossition() {
        return possition;
    }

    public String getTerm_start() {
        return term_start;
    }

    public String getTerm_end() {
        return term_end;
    }
}
