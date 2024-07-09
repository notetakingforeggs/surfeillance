package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import java.util.List;

public class TidalResponse {
    List<TidalEvent> events;

    public TidalResponse(List<TidalEvent> events) {
        this.events = events;
    }

    private TidalResponse() {}

    public List<TidalEvent> getEvents() {
        return events;
    }
}
