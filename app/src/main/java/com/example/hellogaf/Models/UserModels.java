package com.example.hellogaf.Models;

public class UserModels {
    private String firstName;
    private String grade;
    private String review;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }



    public UserModels (String firstName, String grade, String review) {
        this.firstName = firstName;
        this.grade = grade;
        this.review = review;
    }



}
