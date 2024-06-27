package com.northcoders.surfeillance.service.apis.waveAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentMarineData(Double latitude, Double longitude, String timezone, CurrentWaveUnits current_units, CurrentWaveData current ){
}
