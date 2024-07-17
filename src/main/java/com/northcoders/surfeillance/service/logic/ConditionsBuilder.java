package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalEventDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.waveAPI.waveDAO.MarineConditionsDAO;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO.WindConditionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        System.out.println("trying to fetch marine data");
        return apiData.fetchMarineData(spot.getCoordinate());
    }

    public CurrentWeatherData getWeatherData(Spot spot) {
        System.out.println("trying to fetch weather data");
        return apiData.fetchWeather(spot.getCoordinate());
    }

    public TidesDTO getTidalEvent(Spot spot) {

        System.out.println("trying to fetch tidal data");
        return apiData.getTidalEvent(spot.getTideStationId());
    }
}
