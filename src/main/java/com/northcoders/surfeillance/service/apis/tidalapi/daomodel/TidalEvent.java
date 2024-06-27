package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TidalEvent {
    @JsonProperty("EventType")
    public String eventType;
    @JsonProperty("DateTime")
    public Date dateTime;
    @JsonProperty("IsApproximateTime")
    public boolean isApproximateTime;
    @JsonProperty("Height")
    public double height;
    @JsonProperty("IsApproximateHeight")
    public boolean isApproximateHeight;
    @JsonProperty("Filtered")
    public boolean filtered;
    @JsonProperty("Date")
    public Date date;
}
