package com.ilcarro.qa.model;

public class User {
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    /*
    set-Metod
     */
    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /*
    set-Metod
     */
    public User withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    /*
    set-Metod
     */
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    /*
    set-Metod
     */
    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
