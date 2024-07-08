package com.northcoders.surfeillance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.northcoders.surfeillance.model.Coordinate;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveData;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentWaveUnits;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindUnits;
import com.northcoders.surfeillance.service.logic.ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConditionsControllerTest {

    @Mock
    ServiceImpl mockService;

    @InjectMocks
    ConditionController conditionsController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    ConditionsDTO conditionsDTOOne;
    ConditionsDTO conditionsDTOTwo;

    @BeforeEach
    void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(conditionsController).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        TidesDTO tides = new TidesDTO(List.of(
                new TidalEvent("LowWater", null, false, 1.5, false, false, null),
                new TidalEvent("HighWater", null, false, 2.5, false, false, null)
        ));

        conditionsDTOOne = new ConditionsDTO(
                new Spot(1L, "The Beach", new Coordinate(0.5, 0.5), "ABC123"),
                new CurrentMarineData(0.5, 0.5, "GMT", new CurrentWaveUnits("time", "seconds", "1.0", "SW", "0.5"),
                                                        new CurrentWaveData("12:00", 2L, 5L, 4L, 1L)),
                new CurrentWeatherData(0.5, 0.5, "GMT", 1.5, new CurrentWindUnits("12:00", "0.5", "4", "6", "10"),
                        new CurrentWindData("12:00", 0.1, 1.5, 2.0, 3.1)),
                tides);

        conditionsDTOTwo = new ConditionsDTO(
                new Spot(2L, "Pebble Breach", new Coordinate(1.5, 1.5), "ABC456"),
                new CurrentMarineData(0.7, 0.5, "UCT", new CurrentWaveUnits("time", "seconds", "1.0", "SW", "0.5"),
                        new CurrentWaveData("12:30", 2L, 5L, 4L, 1L)),
                new CurrentWeatherData(0.5, 0.5, "UCT", 1.5, new CurrentWindUnits("12:00", "0.5", "4", "6", "10"),
                        new CurrentWindData("12:30", 0.1, 1.5, 2.0, 3.1)),
                tides);
    }

    @Test
    void getAllConditionsReturnsConditions() throws Exception {
        List<ConditionsDTO> conditionsList = new ArrayList<>();
        conditionsList.add(conditionsDTOOne);
        conditionsList.add(conditionsDTOTwo);

        when(mockService.getConditions()).thenReturn(conditionsList);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/conditions"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].spotId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].spotId").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].latitude").value(0.5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].latitude").value(1.5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].timezone").value("GMT"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].timezone").value("UCT"));

        verify(mockService, times(1)).getConditions();
    }

}