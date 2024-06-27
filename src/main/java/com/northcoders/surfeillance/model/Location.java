package com.northcoders.surfeillance.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Location {
    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
