package com.kadyrkuleldos.test_task.models;

import java.util.Date;

public class Wealth {
    private int ID;
    private String category_wealth;
    private String name_wealth;
    private Date date_wealth;
    private int price_wealth;
    private int employee_id;

    public Wealth(int ID, String category_wealth, String name_wealth, Date date_wealth, int price_wealth, int employee_id) {
        this.ID = ID;
        this.category_wealth = category_wealth;
        this.name_wealth = name_wealth;
        this.date_wealth = date_wealth;
        this.price_wealth = price_wealth;
        this.employee_id = employee_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory_wealth() {
        return category_wealth;
    }

    public void setCategory_wealth(String category_wealth) {
        this.category_wealth = category_wealth;
    }

    public String getName_wealth() {
        return name_wealth;
    }

    public void setName_wealth(String name_wealth) {
        this.name_wealth = name_wealth;
    }

    public Date getDate_wealth() {
        return date_wealth;
    }

    public void setDate_wealth(Date date_wealth) {
        this.date_wealth = date_wealth;
    }

    public int getPrice_wealth() {
        return price_wealth;
    }

    public void setPrice_wealth(int price_wealth) {
        this.price_wealth = price_wealth;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
