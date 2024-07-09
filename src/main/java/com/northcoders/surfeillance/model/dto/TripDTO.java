package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.Trip;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class TripDTO {

    private long tripId;
    private AppUserDTO appUserDTO;
    private Spot spot;
    private Integer surfRating;
    private Integer infoRating;
    LocalDate date;
    private Double waveHeight;
    private String waveDirection;
    private Double wavePeriod;
    private Double windSpeed;
    private String windDirection;
    private Integer gusts;
    private Double lowTideHeight;
    private Double highTideHeight;
    private Date lowTideDate;
    private Date highTideDate;

    public TripDTO(Trip trip) {
        this.tripId = trip.getTripId();
        this.appUserDTO = new AppUserDTO(trip.getUser());
        this.spot = trip.getSpot();
        this.surfRating = trip.getSurfRating();
        this.infoRating = trip.getInfoRating();
        this.date = trip.getDate();
        this.waveHeight = trip.getWaveHeight();
        this.waveDirection = trip.getWaveDirection();
        this.wavePeriod = trip.getWavePeriod();
        this.windSpeed = trip.getWindSpeed();
        this.windDirection = trip.getWindDirection();
        this.gusts = trip.getGusts();
        this.lowTideHeight = trip.getLowTideHeight();
        this.highTideHeight = trip.getHighTideHeight();
        this.lowTideDate = trip.getLowTideDate();
        this.highTideDate = trip.getHighTideDate();
    }



}
