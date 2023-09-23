package com.pensatocode.totp.model;

public class PersonalData {
    private String name;
    private String email;

    public PersonalData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
