package com.northcoders.surfeillance.service.apis.weatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentWeatherData(Double latitude, Double longitude, String timezone, Double elevation, CurrentWindUnits current_units, CurrentWindData current) {
}


/*{
    "latitude": 52.52,
    "longitude": 13.419998,
    "generationtime_ms": 0.030994415283203125,
    "utc_offset_seconds": 0,
    "timezone": "GMT",
    "timezone_abbreviation": "GMT",
    "elevation": 38.0,
    "current_units": {
        "time": "iso8601",
        "interval": "seconds",
        "wind_speed_10m": "km/h",
        "wind_direction_10m": "°",
        "wind_gusts_10m": "km/h"
    },
    "current": {
        "time": "2024-06-27T12:00",
        "interval": 900,
        "wind_speed_10m": 5.9,
        "wind_direction_10m": 166,
        "wind_gusts_10m": 17.6
    }
}*/