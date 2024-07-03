package com.northcoders.surfeillance.service.apis.tidalapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.Feature;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.Geometry;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TidalStationDAOTest {

    @Mock
    private HttpClient httpClient;


    @Mock
    private HttpResponse<String> mockHttpResponse;


    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private TidalStationDAO tidalStation;

    @Test
    void tidalStationsDAO() {


        String jsonObj = "{\n" +
                "    \"features\": [\n" +
                "        {\n" +
                "            \"geometry\": {\n" +
                "                \"coordinates\": [\n" +
                "                    -8.566666,\n" +
                "                    57.8\n" +
                "                ]\n" +
                "            },\n" +
                "            \"properties\": {\n" +
                "                \"Id\": \"0322\",\n" +
                "                \"Name\": \"Hirta (Bagh A' Bhaile)\",\n" +
                "                \"Country\": \"Scotland\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        HttpResponse httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(jsonObj);

        HttpClient httpClientMock = mock(HttpClient.class);
        try(MockedStatic<HttpClient> httpClientMockedStatic = mockStatic(HttpClient.class)) {
            httpClientMockedStatic.when(HttpClient::newHttpClient).thenReturn(httpClientMock);
            when(httpClientMock.send(Mockito.any(HttpRequest.class), ArgumentMatchers.<HttpResponse.BodyHandler<String>>any()))
                    .thenReturn(httpResponse);

            String actualResponse = TidalStationDAO.tidalStationsDAO().toString();

            Assertions.assertEquals(jsonObj, actualResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}