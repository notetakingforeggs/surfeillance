package com.northcoders.surfeillance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeTrip {

    int tripID;
    Integer userID;
    String dateTime;
    FakeLocation locationConditions;
    Integer surfRating;
    Integer infoRating;


    public FakeTrip(int tripID, Integer userID, String dateTime, FakeLocation locationConditions, Integer surfRating, Integer infoRating) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.locationConditions = locationConditions;
        this.surfRating = surfRating;
        this.infoRating = infoRating;
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

    public Integer getSurfRating() {
        return surfRating;
    }

    public void setSurfRating(Integer surfRating) {
        this.surfRating = surfRating;
    }

    public Integer getInfoRating() {
        return infoRating;
    }

    public void setInfoRating(Integer infoRating) {
        this.infoRating = infoRating;
    }
}