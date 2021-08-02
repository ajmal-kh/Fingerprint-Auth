package com.ak.test;

public class User {
    String userId;
    String first;
    String last;
    String mobile;
    String altMobile;
    String pin;
    String house;
    String road;
    String landmark;
    String city;
    String state;

    public  User(){

    }

    public User(String userId, String first, String last, String mobile, String altMobile, String pin, String house, String road, String landmark, String city, String state) {
        this.userId = userId;
        this.first = first;
        this.last = last;
        this.mobile = mobile;
        this.altMobile = altMobile;
        this.pin = pin;
        this.house = house;
        this.road = road;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAltMobile() {
        return altMobile;
    }

    public String getPin() {
        return pin;
    }

    public String getHouse() {
        return house;
    }

    public String getRoad() {
        return road;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}

