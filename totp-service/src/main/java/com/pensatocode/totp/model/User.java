package com.pensatocode.totp.model;

public class User {

    private Long id;
    private PersonalData personalData;
    private Credential credential;

    public User(Long id, PersonalData personalData, Credential credential) {
        this.id = id;
        this.personalData = personalData;
        this.credential = credential;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Credential getCredentials() {
        return credential;
    }

    public void setCredentials(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "User{" +
                "personalData=" + personalData +
                ", credentials=" + credential +
                '}';
    }
}
