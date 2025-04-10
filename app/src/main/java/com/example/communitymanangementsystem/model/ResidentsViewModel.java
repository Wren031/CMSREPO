package com.example.communitymanangementsystem.model;

public class ResidentsViewModel {
    private int residentsId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String birthday;
    private String email;
    private String citizenship;
    private String religion;
    private String age;
    private String contactNumber;
    private String education;
    private String maritalStatus;
    private String weight;
    private String sector;
    private String houseBldg;
    private String height;
    private String sinceYear;
    private String sitio;
    private String houseOwner;
    private String purok;
    private String houseMaterial;
    private String familyHead;
    private String shelterType;
    private String status;
    private String createdAt;


    public ResidentsViewModel(int residentsId, String firstName, String middleName, String lastName, String gender, String birthday, String email, String citizenship, String religion, String age, String contactNumber, String education, String maritalStatus, String weight, String sector, String houseBldg, String height, String sinceYear, String sitio, String houseOwner, String purok, String houseMaterial, String familyHead, String shelterType, String status, String createdAt) {
        this.residentsId = residentsId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.citizenship = citizenship;
        this.religion = religion;
        this.age = age;
        this.contactNumber = contactNumber;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.weight = weight;
        this.sector = sector;
        this.houseBldg = houseBldg;
        this.height = height;
        this.sinceYear = sinceYear;
        this.sitio = sitio;
        this.houseOwner = houseOwner;
        this.purok = purok;
        this.houseMaterial = houseMaterial;
        this.familyHead = familyHead;
        this.shelterType = shelterType;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getResidentsId() {
        return residentsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getReligion() {
        return religion;
    }

    public String getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEducation() {
        return education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getWeight() {
        return weight;
    }

    public String getSector() {
        return sector;
    }

    public String getHouseBldg() {
        return houseBldg;
    }

    public String getHeight() {
        return height;
    }

    public String getSinceYear() {
        return sinceYear;
    }

    public String getSitio() {
        return sitio;
    }

    public String getHouseOwner() {
        return houseOwner;
    }

    public String getPurok() {
        return purok;
    }

    public String getHouseMaterial() {
        return houseMaterial;
    }

    public String getFamilyHead() {
        return familyHead;
    }

    public String getShelterType() {
        return shelterType;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getFullName(){
        return this.firstName + " " + middleName + " " + lastName;
    }
}
