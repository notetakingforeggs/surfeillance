package com.northcoders.surfeillance.service.apis.tidalapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class TidalStationDAO {

    static TidalApiConfig config = new TidalApiConfig();
    static final String BASE_URL = config.getBaseUrl();
    static final String HEADER_KEY = config.getHeaderKey();
    static final String HEADER_VALUE = config.getHeaderVal();


    public static Root tidalStationsDAO(){

        ObjectMapper om = new ObjectMapper();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL))
                    .header(HEADER_KEY, HEADER_VALUE)
                    .GET().build();
            var response = client.send(req, HttpResponse.BodyHandlers.ofString());

            var root = om.readValue(response.body(), Root.class);
            return root;
        } catch(IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;

    }
}