package com.kadyrkuleldos.test_task.models;

public class Employees {

    private int ID;
    private String firstname;
    private String lastname;
    private String Surname;
    private String Email;
    private String Gender;

    public Employees(int ID, String firstnameEmp, String lastnameEmp, String surname, String email, String gender) {
        this.ID = ID;
        firstname = firstnameEmp;
        lastname = lastnameEmp;
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
        return firstname;
    }

    public void setFirstname(String firstnameEmp) {
        firstname = firstnameEmp;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastnameEmp) {
        lastname = lastnameEmp;
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
