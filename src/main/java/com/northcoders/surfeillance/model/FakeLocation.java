package com.northcoders.surfeillance.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FakeLocation {
    String name;
    String details;
    String requestTime;
    String latitude;
    String longitude;
    String timezone;
    Double waveHeight;
    String waveDirection;
    Double wavePeriod;
    Double windSpeed;
    Double gusts;
    Double highTideHeight;
    String highTideTime;
    Double lowTideHeight;
    String lowTideTime;
}

