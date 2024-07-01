package com.northcoders.surfeillance.model.dto;


/*
The parent DTO object that wil be used to provide data to the frontend.
Will be built in the service layer from a combo of database and 3P-API calls
 */

import com.northcoders.surfeillance.model.Spot;

public class ConditionsDTO {

    private Spot spot;
    private TidalEventDTO tidalEventDTO;
    private CurrentMarineData currentMarineData;
    private CurrentWaveData currentWaveData;
    private CurrentWaveUnits currentWaveUnits;

    public ConditionsDTO(Spot spot, TidalEventDTO tidalEventDTO, CurrentMarineData currentMarineData, CurrentWaveData currentWaveData, CurrentWaveUnits currentWaveUnits) {
        this.spot = spot;
        this.tidalEventDTO = tidalEventDTO;
        this.currentMarineData = currentMarineData;
        this.currentWaveData = currentWaveData;
        this.currentWaveUnits = currentWaveUnits;
    }
}
