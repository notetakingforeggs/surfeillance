package com.northcoders.surfeillance.service.apis.waveAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// maybe these could be chars rather than strings?
@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentWaveUnits(String time, String seconds, String wave_height, String wave_direction, String wave_period){
}


