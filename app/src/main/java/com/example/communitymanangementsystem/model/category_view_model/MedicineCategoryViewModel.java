package com.example.communitymanangementsystem.model.category_view_model;

public class MedicineCategoryViewModel {

    int medicine_catergory_Id;
    String name;
    String createAt;

    public MedicineCategoryViewModel(int medicine_catergory_Id, String name, String createAt) {
        this.medicine_catergory_Id = medicine_catergory_Id;
        this.name = name;
        this.createAt = createAt;
    }

    public int getMedicine_catergory_Id() {
        return medicine_catergory_Id;
    }

    public String getName() {
        return name;
    }

    public String getCreateAt() {
        return createAt;
    }
}
