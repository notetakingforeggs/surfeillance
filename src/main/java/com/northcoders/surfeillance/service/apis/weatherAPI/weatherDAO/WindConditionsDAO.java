

package com.northcoders.surfeillance.service.apis.weatherAPI.weatherDAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWeatherData;
import com.northcoders.surfeillance.service.apis.weatherAPI.CurrentWindData;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WindConditionsDAO {

    private final static String BASE_URL_START = "https://api.open-meteo.com/v1/forecast?";
    private final static String BASE_URL_END = "&current=wind_speed_10m,wind_direction_10m,wind_gusts_10m";

    //"https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=wind_speed_10m,wind_direction_10m,wind_gusts_10m"
    public static CurrentWeatherData getWindCondition(Double latitude, Double longitude) {

        String latitudeString = "latitude=" + latitude + "&";
        String longitudeString = "longitude=" + longitude;

        try {
            HttpResponse<String> response;
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL_START + latitudeString + longitudeString + BASE_URL_END))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            return mapper.readValue(response.body(), CurrentWeatherData.class);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}


