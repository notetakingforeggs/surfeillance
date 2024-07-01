package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Coordinate;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalEventDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalStationDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.waveDAO.MarineConditionsDAO;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO.WindConditionsDAO;

public class APIDataGatherer {

    public CurrentWeatherData fetchWeather(Coordinate coordinate) {
      return WindConditionsDAO.getWindCondition(coordinate.getLatitude(), coordinate.getLongitude());
    };

    public CurrentMarineData fetchMarineData(Coordinate coordinate) {
        return MarineConditionsDAO.getMarineCondition(coordinate.getLatitude(), coordinate.getLongitude());
    }

    public TidalEvent getTidalEvent(String stationId) {
        return TidalEventDAO.getTideByLocation(stationId);
    }

}
