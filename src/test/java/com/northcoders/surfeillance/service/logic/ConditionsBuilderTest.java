package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Coordinate;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConditionsBuilderTest {

    @Mock
    CurrentWeatherData mockWeatherData;

    @Mock
    CurrentMarineData mockMarineData;

    @Mock
    TidesDTO mockTidesDTO;

    @Mock
    Spot spot;

    @Mock
    APIDataGatherer apiMock;

    @InjectMocks
    ConditionsBuilder conditionsBuilder;

    @Test
    void getMarineDataShouldGetMarineData() {
        when(apiMock.fetchMarineData(any(Coordinate.class))).thenReturn(mockMarineData);

        Coordinate coordinate = new Coordinate(0.5, 0.5);
        when(spot.getCoordinate()).thenReturn(coordinate);

        when(mockMarineData.timezone()).thenReturn("GMT");

        CurrentMarineData actualData = conditionsBuilder.getMarineData(spot);

        assertEquals("GMT", actualData.timezone());
        verify(apiMock, times(1)).fetchMarineData(any(Coordinate.class));
    }

    @Test
    void getWeatherDataShouldGetWeatherData() {
        when(apiMock.fetchWeather(any(Coordinate.class))).thenReturn(mockWeatherData);

        Coordinate coordinate = new Coordinate(0.5, 0.5);
        when(spot.getCoordinate()).thenReturn(coordinate);

        when(mockWeatherData.timezone()).thenReturn("GMT");

        CurrentWeatherData actualData = conditionsBuilder.getWeatherData(spot);

        assertEquals("GMT", actualData.timezone());
        verify(apiMock, times(1)).fetchWeather(any(Coordinate.class));
    }

    @Test
    void getTidalEventDataShouldGetTidalEventData() {
        when(apiMock.getTidalEvent(anyString())).thenReturn(mockTidesDTO);

        when(spot.getTideStationId()).thenReturn("ABC123");

        when(mockTidesDTO.getLowWaterHeight()).thenReturn(1.5);

        TidesDTO actualData = conditionsBuilder.getTidalEvent(spot);

        assertEquals(1.5, actualData.getLowWaterHeight());
        verify(apiMock, times(1)).getTidalEvent(anyString());
    }


}