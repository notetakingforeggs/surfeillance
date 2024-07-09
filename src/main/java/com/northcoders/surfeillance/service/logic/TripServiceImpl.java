package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.NewTripDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.TripUpdatesDTO;
import com.northcoders.surfeillance.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
                    newTrip.getLowTideHeight(),
                    newTrip.getHighTideHeight(),
                    newTrip.getLowTideDate(),
                    newTrip.getHighTideDate()
                )
        );
    }

    @Override
    public Trip updateTrip(int id, TripUpdatesDTO tripUpdates) {
        if(!tripRepository.existsById(id)) {
            return null;
        } else {
            Optional<Trip> optionalTripToUpdate = tripRepository.findById(id);
            if (optionalTripToUpdate.isEmpty()) return null;
            Trip updatedTrip = optionalTripToUpdate.get();
            applyUpdate(updatedTrip, tripUpdates);
            tripRepository.save(updatedTrip);
            return updatedTrip;
        }
    }

    private void applyUpdate(Trip trip, TripUpdatesDTO tripUpdates) {
        if (tripUpdates.getInfoRating() != null) trip.setInfoRating(tripUpdates.getInfoRating());
        if (tripUpdates.getSurfRating() != null) trip.setSurfRating(tripUpdates.getSurfRating());
    }
}
