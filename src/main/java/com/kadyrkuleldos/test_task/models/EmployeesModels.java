package com.kadyrkuleldos.test_task.models;

import javax.persistence.Entity;

@Entity(name = "EmployeeModels")
public class EmployeesModels {

    private int ID;

    public EmployeesModels(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
