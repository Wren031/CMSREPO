package com.example.communitymanangementsystem.ui.content.family.model;

import com.example.communitymanangementsystem.model.ResidentsViewModel;

public class FamilyMemberViewModel {
    int familyMemberId;
    String type;
    ResidentsViewModel residentsViewModel;

    public FamilyMemberViewModel(int familyMemberId, String type, ResidentsViewModel residentsViewModel) {
        this.familyMemberId = familyMemberId;
        this.type = type;
        this.residentsViewModel = residentsViewModel;
    }

    public int getFamilyMemberId() {
        return familyMemberId;
    }

    public String getType() {
        return type;
    }

    public ResidentsViewModel getResidentsViewModel() {
        return residentsViewModel;
    }
}
