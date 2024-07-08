package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.Spot;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewTripDTO {
    private AppUser appUser;
    private Spot spot;
    private LocalDate date;
    private Double waveHeight;
    private String waveDirection;
    private Double wavePeriod;
    private Double windSpeed;
    private String windDirection;
    private Integer gusts;
    private Double tideHeight;
}
