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


    public ConditionsDTO conditionBuilder(Spot spot) {

        CurrentMarineData currentMarineData = MarineConditionsDAO.getMarineCondition(spot.getCoordinate().getLatitude(), spot.getCoordinate().getLongitude());
        CurrentWeatherData currentWeatherData = WindConditionsDAO.getWindCondition(spot.getCoordinate().getLatitude(), spot.getCoordinate().getLongitude());
        TidalEvent tidalEvent = TidalEventDAO.getTideByLocation(spot.getTideStationId());

        return new ConditionsDTO(spot, currentMarineData, currentWeatherData, tidalEvent);
    }
}
