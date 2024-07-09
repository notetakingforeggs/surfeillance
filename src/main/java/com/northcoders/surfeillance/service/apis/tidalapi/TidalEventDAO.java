package com.northcoders.surfeillance.service.apis.tidalapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TidalEventDAO {

    static TidalApiConfig config = new TidalApiConfig();
    static final String BASE_URL = config.getTidalEventBaseUrl();
    static final String HEADER_KEY = config.getHeaderKey();
    static final String HEADER_VALUE = config.getHeaderVal();

    public static TidesDTO getTideByLocation(String stationId){
        ObjectMapper om = new ObjectMapper();
        String url = String.format(BASE_URL, stationId);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header(HEADER_KEY,HEADER_VALUE)
                    .GET().build();
            var response = client.send(req, HttpResponse.BodyHandlers.ofString());

            List<TidalEvent> tidalEvents = om.readValue(response.body(), new TypeReference<List<TidalEvent>>() {});


            return TidesUtil.getForthComingTides(tidalEvents);
        } catch(IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;

    }
}
