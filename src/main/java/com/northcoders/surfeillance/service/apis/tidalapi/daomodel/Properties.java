package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("ContinuousHeightsAvailable")
    public boolean continuousHeightsAvailable;
    @JsonProperty("Footnote")
    public String footnote;
}
