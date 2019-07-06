package com.kadyrkuleldos.test_task.models;

public class Employees {

    private int ID;
    private String Firstname;
    private String Lastname;
    private String Surname;
    private String Email;
    private String Gender;

    public Employees(int ID, String firstname, String lastname, String surname, String email, String gender) {
        this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
        Surname = surname;
        Email = email;
        Gender = gender;
    }

    public Employees() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
