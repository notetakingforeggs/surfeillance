package com.northcoders.surfeillance.model.dto;

import lombok.Data;

@Data
public class TripUpdatesDTO {

    private Integer surfRating;
    private Integer infoRating;

    public TripUpdatesDTO(Integer surfRating, Integer infoRating) {
        this.surfRating = surfRating;
        this.infoRating = infoRating;
    }
}
