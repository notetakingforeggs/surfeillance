//package com.northcoders.surfeillance.service.logic;
//
//import com.northcoders.surfeillance.model.Coordinate;
//import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
//import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
//import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveUnits;
//import com.northcoders.surfeillance.service.apis.waveAPI.waveDAO.MarineConditionsDAO;
//import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
//import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindData;
//import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindUnits;
//import com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO.WindConditionsDAO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockedStatic;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyDouble;
//import static org.mockito.Mockito.*;
//
//
//class APIDataGathererTest {
//
//    // Weather
//    CurrentWindUnits currentWindUnits;
//    CurrentWindData currentWindData;
//    CurrentWeatherData currentWeatherData;
//
//    // Wind
//    CurrentWaveUnits currentWaveUnits;
//    CurrentWaveData currentWaveData;
//    CurrentMarineData currentMarineData;
//
//    //Test class
//    APIDataGatherer apiDataGatherer;
//
//
//    @BeforeEach
//    void setup() {
//        currentWindUnits = new CurrentWindUnits("iso8601", "seconds", "km/h", "°", "km/h");
//        currentWindData = new CurrentWindData("2024-06-27T12:00", 900.0, 5.9, 166.0, 17.6);
//        currentWeatherData = new CurrentWeatherData(0.5, 0.5, "GMT", 38.0, currentWindUnits, currentWindData);
//
//        currentWaveUnits = new CurrentWaveUnits("iso8601", "seconds", "1.0", "NW", "start");
//        currentWaveData = new CurrentWaveData("2024-06-27T12:00", 12L, 15L, 0L, 5L);
//        currentMarineData = new CurrentMarineData(0.5, 0.5, "GMT", currentWaveUnits, currentWaveData);
//
//
//        apiDataGatherer = new APIDataGatherer();
//
//    }
//    @Test
//    void fetchWeatherShouldFetchWeather() {
//
//        MockedStatic<WindConditionsDAO> mockedStaticClass = mockStatic(WindConditionsDAO.class);
//
//        mockedStaticClass.when(() -> WindConditionsDAO.getWindCondition(anyDouble(), anyDouble())).thenReturn(currentWeatherData);
//
//        CurrentWeatherData actualData = apiDataGatherer.fetchWeather(new Coordinate(0.5, 0.5));
//
//        assertEquals(0.5, actualData.latitude());
//        assertEquals(0.5, actualData.longitude());
//        assertEquals("GMT", actualData.timezone());
//        assertEquals("seconds", actualData.current_units().interval());
//        assertEquals(900.0, actualData.current().interval());
//
//        mockedStaticClass.verify(() -> WindConditionsDAO.getWindCondition(anyDouble(), anyDouble()));
//    }
//
//    @Test
//    void fetchMarineDataShouldFetchData() {
//
//        MockedStatic<MarineConditionsDAO> mockedStaticClass = mockStatic(MarineConditionsDAO.class);
//
//        mockedStaticClass.when(() -> MarineConditionsDAO.getMarineCondition(anyDouble(), anyDouble())).thenReturn(currentMarineData);
//
//        CurrentMarineData actualData = apiDataGatherer.fetchMarineData(new Coordinate(0.5, 0.5));
//
//        assertEquals(0.5, actualData.latitude());
//        assertEquals(0.5, actualData.longitude());
//        assertEquals("GMT", actualData.timezone());
//        assertEquals("seconds", actualData.current_units().seconds());
//        assertEquals(0L, actualData.current().wave_direction());
//
//
//        mockedStaticClass.verify(() -> WindConditionsDAO.getWindCondition(anyDouble(), anyDouble()));
//    }
//
//}