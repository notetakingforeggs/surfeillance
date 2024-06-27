package com.northcoders.surfeillance.service.apis.waveAPI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentWaveData(String time, Long interval, Long wave_height, Long wave_direction, Long wave_period){
}

