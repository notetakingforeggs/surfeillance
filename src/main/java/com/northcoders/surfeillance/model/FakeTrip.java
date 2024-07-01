package com.northcoders.surfeillance.model;

public class FakeTrip {

    int tripID;
    Integer userID;
    String dateTime;
    FakeLocation locationConditions;


    public FakeTrip(int tripID, Integer userID, String dateTime, FakeLocation locationConditions) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.locationConditions = locationConditions;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public FakeLocation getLocationConditions() {
        return locationConditions;
    }

    public void setLocationConditions(FakeLocation locationConditions) {
        this.locationConditions = locationConditions;
    }

}
