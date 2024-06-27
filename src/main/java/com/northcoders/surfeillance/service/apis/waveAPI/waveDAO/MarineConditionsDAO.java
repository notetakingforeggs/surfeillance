package com.northcoders.surfeillance.service.apis.waveAPI.waveDAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.surfeillance.service.apis.waveAPI.CurrentMarineData;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarineConditionsDAO {

    private final static String BASE_URL_START = "https://marine-api.open-meteo.com/v1/marine?";
    private final static String BASE_URL_END = "&current=wave_height,wave_direction,wave_period&timezone=GMT";
// total query: https://marine-api.open-meteo.com/v1/marine?latitude=50.4156&longitude=-5.0732&current=wave_height,wave_direction,wave_period&timezone=GMT

    public static CurrentMarineData getMarineCondition(Double latitude, Double longitude) {

        String latitudeString = "latitude=" + latitude + "&";
        String longitudeString = "longitude=" + longitude;

        try {
            HttpResponse<String> response;
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL_START+latitudeString+longitudeString+BASE_URL_END))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            CurrentMarineData currentMarineData = mapper.readValue(response.body(), CurrentMarineData.class);
            return currentMarineData;

        }catch (URISyntaxException | InterruptedException | IOException e){
            e.printStackTrace();
            return null;
        }

    }
}
