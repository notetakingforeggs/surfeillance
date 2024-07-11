package com.northcoders.surfeillance.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import lombok.Data;

import java.util.Date;

@Data
public class ConditionsDTO {

    long spotId;
    String name;
    String details;
    String requestTime;
    Double latitude;
    Double longitude;
    String timezone;
    Long waveHeight;
    Long waveDirection;
    Long wavePeriod;
    Double windSpeed;
    Double windDirection;
    Double gusts;
    Date lowTideTime;
    Double lowTideHeight;
    Date highTideTime;
    Double highTideHeight;

    public ConditionsDTO(Spot spot, CurrentMarineData currentMarineData, CurrentWeatherData currentWeatherData, TidesDTO tidesDTO) {
        this.spotId = spot.getSpotId();
        this.name = spot.getLocationName();
        this.details = spot.getLocationName() + " is a beautiful place to go for a surf";
        this.requestTime = currentMarineData.current().time();
        this.latitude = spot.getCoordinate().getLatitude();
        this.longitude = spot.getCoordinate().getLongitude();
        this.timezone = currentMarineData.timezone();
        this.waveHeight = currentMarineData.current().wave_height();
        this.waveDirection = currentMarineData.current().wave_direction();
        this.wavePeriod = currentMarineData.current().wave_period();
        this.windSpeed = currentWeatherData.current().wind_speed_10m();
        this.windDirection = currentWeatherData.current().wind_direction_10m();
        this.gusts = currentWeatherData.current().wind_gusts_10m();
        this.lowTideTime = tidesDTO.getLowWaterTime();
        this.lowTideHeight = tidesDTO.getLowWaterHeight();
        this.highTideTime = tidesDTO.getHighWaterTime();
        this.highTideHeight = tidesDTO.getHighWaterHeight();
    }

    public ConditionsDTO(long spotId, String name, String details, String requestTime, Double latitude, Double longitude, String timezone, Long waveHeight, Long waveDirection, Long wavePeriod, Double windSpeed, Double windDirection, Double gusts, Date lowTideTime, Double lowTideHeight, Date highTideTime, Double highTideHeight) {
        this.spotId = spotId;
        this.name = name;
        this.details = details;
        this.requestTime = requestTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.gusts = gusts;
        this.lowTideTime = lowTideTime;
        this.lowTideHeight = lowTideHeight;
        this.highTideTime = highTideTime;
        this.highTideHeight = highTideHeight;
    }
}

