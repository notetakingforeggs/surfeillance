package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
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

    public TidalEvent(String eventType, Date dateTime, boolean isApproximateTime, double height, boolean isApproximateHeight, boolean filtered, Date date) {
        this.eventType = eventType;
        this.dateTime = dateTime;
        this.isApproximateTime = isApproximateTime;
        this.height = height;
        this.isApproximateHeight = isApproximateHeight;
        this.filtered = filtered;
        this.date = date;
    }
}
