package com.example.hellogaf.Models;

public class UserModels {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public UserModels (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
