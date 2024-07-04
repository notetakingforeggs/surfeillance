package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.NewTripDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.TripUpdatesDTO;
import com.northcoders.surfeillance.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TripServiceImpl implements TripService{

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<TripDTO> getAllTripsByUser(int id){
        return tripRepository.findByUserId(id).stream().map(TripDTO::new).collect(Collectors.toList());
    }

    @Override
    public Trip createTrip(NewTripDTO newTrip) {
        return tripRepository.save(
                new Trip(
                    newTrip.getAppUser(),
                    newTrip.getSpot(),
                    newTrip.getDate(),
                    newTrip.getWaveHeight(),
                    newTrip.getWaveDirection(),
                    newTrip.getWavePeriod(),
                    newTrip.getWindSpeed(),
                    newTrip.getWindDirection(),
                    newTrip.getGusts(),
                    newTrip.getTideHeight()
                )
        );
    }

    @Override
    public Trip updateTrip(TripUpdatesDTO tripUpdates) {
        return null;
    }
}
