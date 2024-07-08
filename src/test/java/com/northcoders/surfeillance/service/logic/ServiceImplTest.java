package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Coordinate;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.repository.SpotRepository;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveUnits;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindUnits;
import com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO.WindConditionsDAO;
import org.assertj.core.internal.Conditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.exceptions.misusing.UnfinishedVerificationException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock
    SpotRepository spotRepository;

    @Mock
    ConditionsBuilder conditionsBuilder;

    @Mock
    List<Spot> spotList;

    @Mock
    Iterator<Spot> mockIterator;

    @Mock
    Spot spotOne;

    @Mock
    Spot spotTwo;

    // Test class
    @InjectMocks
    ServiceImpl service;



    @Test
    void getConditions() {

        spotList.add(spotOne);
        spotList.add(spotTwo);

        when(spotRepository.findAll()).thenReturn(spotList);

        when(spotList.iterator()).thenReturn(mockIterator);

        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn(spotOne, spotTwo);

        ConditionsDTO conditionOne = new ConditionsDTO(
                new Spot(1L, "The Beach", new Coordinate(0.5, 0.5), "ABC123"),
                new CurrentMarineData(0.5, 0.5, "GMT", new CurrentWaveUnits("", "", "", "", ""), new CurrentWaveData("", 1L, 1L, 1L, 1L)),
                new CurrentWeatherData(0.5, 0.5, "GMT", 1.5, new CurrentWindUnits("", "", "", "", ""), new CurrentWindData("", 0.5, 0.5, 0.5, 0.5)),
                new TidesDTO(List.of(
                        new TidalEvent("LowWater", null, true, 1.5, false, false, null),
                        new TidalEvent("HighWater", null, true, 2.5, false, false, null)
                )));

        ConditionsDTO conditionTwo = new ConditionsDTO(
                new Spot(2L, "Pebble Breach", new Coordinate(1.5, 1.5), "ABC456"),
                new CurrentMarineData(0.5, 0.5, "GMT", new CurrentWaveUnits("", "", "", "", ""), new CurrentWaveData("", 1L, 1L, 1L, 1L)),
                new CurrentWeatherData(0.5, 0.5, "GMT", 1.5, new CurrentWindUnits("", "", "", "", ""), new CurrentWindData("", 0.5, 0.5, 0.5, 0.5)),
                new TidesDTO(List.of(
                        new TidalEvent("LowWater", null, true, 1.5, false, false, null),
                        new TidalEvent("HighWater", null, true, 2.5, false, false, null)
                )));

        when(conditionsBuilder.conditionBuilder(spotOne)).thenReturn(conditionOne);
        when(conditionsBuilder.conditionBuilder(spotTwo)).thenReturn(conditionTwo);


        List<ConditionsDTO> actualList = service.getConditions();

        assertEquals(2, actualList.size());

        verify(spotRepository, times(1)).findAll();
        verify(conditionsBuilder, times(2)).conditionBuilder(any(Spot.class));
        verify(mockIterator, times(3)).hasNext();
        verify(mockIterator, times(2)).next();
        verify(spotList, times(1)).iterator();



    }
}