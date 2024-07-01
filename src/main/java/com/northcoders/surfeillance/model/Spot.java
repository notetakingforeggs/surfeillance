package com.northcoders.surfeillance.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long spotId;

    @Setter
    @Column
    private String locationName;

    @Embedded
    private Coordinate coordinate;

    @Setter
    @Column
    private String tideStationId;

    public Spot(long spotId, String locationName, Coordinate coordinate) {
        this.spotId = spotId;
        this.locationName = locationName;
        this.coordinate = coordinate;
    }

}
