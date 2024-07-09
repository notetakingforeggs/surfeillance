package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import lombok.Getter;

import java.util.List;

@Getter
public class TidalResponse {
    List<TidalEvent> events;

    public TidalResponse(List<TidalEvent> events) {
        this.events = events;
    }

    private TidalResponse() {}

}
