package com.northcoders.surfeillance.model.dto;

public class AddRatingsDTO {

    /*
    To be used with a PATCH request to update ratings
    on existing trips
     */

    private long tripId;
    private int infoRating;
    private int surfRating;

    public AddRatingsDTO(long tripId, int infoRating, int surfRating) {
        this.tripId = tripId;
        this.infoRating = infoRating;
        this.surfRating = surfRating;
    }
}
