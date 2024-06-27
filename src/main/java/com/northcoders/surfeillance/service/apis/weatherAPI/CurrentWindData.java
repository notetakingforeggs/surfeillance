package com.northcoders.surfeillance.service.apis.weatherAPI;

public record CurrentWindData(String time, Double interval, Double wind_speed_10m, Double wind_direction_10m, Double wind_gusts_10m) {
}
