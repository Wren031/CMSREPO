package com.example.communitymanangementsystem.model;

import com.example.communitymanangementsystem.model.category_view_model.MedicineCategoryViewModel;

public class MedicineViewModel {
    int medicineId;
    MedicineCategoryViewModel category;
    int stock;
    String manufactor;
    String expiry_date;
    int image;
    String name;
    String createAt;

    public MedicineViewModel(int medicineId, MedicineCategoryViewModel category, int stock, String manufactor, String expiry_date, int image, String createAt, String name) {
        this.medicineId = medicineId;
        this.category = category;
        this.stock = stock;
        this.manufactor = manufactor;
        this.expiry_date = expiry_date;
        this.image = image;
        this.createAt = createAt;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public MedicineCategoryViewModel getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public String getManufactor() {
        return manufactor;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public int getImage() {
        return image;
    }

    public String getCreateAt() {
        return createAt;
    }
}
