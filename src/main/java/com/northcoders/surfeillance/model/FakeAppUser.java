package com.northcoders.surfeillance.model;

import java.util.List;

public class FakeAppUser {
    int id;
    String userName;
    String homeLocation;
    List<Integer> favouriteSpots;
    Integer skillLevel;

    public FakeAppUser(int id, String userName, String homeLocation, List<Integer> favouriteSpots, Integer skillLevel) {
        this.id = id;
        this.userName = userName;
        this.homeLocation = homeLocation;
        this.favouriteSpots = favouriteSpots;
        this.skillLevel = skillLevel;
    }

    public FakeAppUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public List<Integer> getFavouriteSpots() {
        return favouriteSpots;
    }

    public void setFavouriteSpots(List<Integer> favouriteSpots) {
        this.favouriteSpots = favouriteSpots;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }
}
