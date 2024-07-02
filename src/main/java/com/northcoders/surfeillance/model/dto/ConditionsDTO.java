package com.northcoders.surfeillance.model.dto;


/*
The parent DTO object that wil be used to provide data to the frontend.
Will be built in the service layer from a combo of database and 3P-API calls
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import lombok.Data;

@Data
public class ConditionsDTO {

    @JsonProperty("spot")
    private Spot spot;
    @JsonProperty("currentMarineData")
    private CurrentMarineData currentMarineData;
    @JsonProperty("currentWeatherData")
    private CurrentWeatherData currentWeatherData;
    @JsonProperty("tidalEvent")
    private TidalEvent tidalEventDTO;

    public ConditionsDTO(Spot spot, CurrentMarineData currentMarineData, CurrentWeatherData currentWeatherData, TidalEvent tidalEventDTO) {
        this.spot = spot;
        this.currentMarineData = currentMarineData;
        this.currentWeatherData = currentWeatherData;
        this.tidalEventDTO = tidalEventDTO;
    }
}
