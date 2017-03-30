package com.BmCollege.app.Queries;

/**
 * Created by Vineet Jain on 1/15/2017.
 */

public class Query_class {

    private String textName, address, city, state, number, query;

    public Query_class(){

    }

    public Query_class(String textName, String address, String city, String state, String number, String query) {
        this.textName = textName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.number = number;
        this.query = query;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}