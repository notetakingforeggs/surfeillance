package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalEventDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.waveAPI.waveDAO.MarineConditionsDAO;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO.WindConditionsDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class ConditionsBuilder {

    @Autowired
    APIDataGatherer apiData;


    public ConditionsDTO conditionBuilder(Spot spot) {
        return new ConditionsDTO(spot,
                getMarineData(spot),
                getWeatherData(spot),
                getTidalEvent(spot));
    }

    public CurrentMarineData getMarineData(Spot spot) {
        return apiData.fetchMarineData(spot.getCoordinate());
    }

    public CurrentWeatherData getWeatherData(Spot spot) {
        return apiData.fetchWeather(spot.getCoordinate());
    }

    public TidalEvent getTidalEvent(Spot spot) {
        return apiData.getTidalEvent(spot.getTideStationId());
    }
}
