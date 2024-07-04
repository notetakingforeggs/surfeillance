package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.TripDTO;

import java.util.List;

public interface TripService {
    List<TripDTO> getAllTrips();
    Trip createTrip(NewTripDTO newTrip);
    Trip updateTrip(TripUpdatesDTO tripUpdates);

}
