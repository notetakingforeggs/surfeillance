package com.northcoders.surfeillance.service.apis.tidalapi;

import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;

import java.util.Date;
import java.util.List;

public class TidesUtil {

    public static TidesDTO getForthComingTides(List<TidalEvent> fullTidesList) {

        Date currentDate = new Date();

        List<TidalEvent> upcomingEvents = fullTidesList.stream()
                .filter(event -> event.getDateTime().after(currentDate))
                .sorted((d1, d2) -> d1.getDateTime().compareTo(d2.getDateTime()))
                .toList();

        List<TidalEvent> nextTwoEvents = upcomingEvents.stream().limit(2).toList();

        return new TidesDTO(nextTwoEvents);

    }
}
