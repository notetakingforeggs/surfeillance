package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.NewTripDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.TripUpdatesDTO;

import java.util.List;

public interface TripService {
    List<TripDTO> getAllTripsByUser(int id);
    Trip createTrip(NewTripDTO newTrip);
    Trip updateTrip(int id, TripUpdatesDTO tripUpdates);

}
