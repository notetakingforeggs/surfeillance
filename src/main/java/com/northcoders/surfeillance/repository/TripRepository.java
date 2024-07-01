package com.northcoders.surfeillance.repository;

import com.northcoders.surfeillance.model.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {

    // exists as a standard CrudRepository method
    // find a trip by ID
    // save()

    // Returns a list of trips based on AppuserId in order to populate a recycler view
    List<Trip> findByUserId(long id);

    // Returns a list of trips based on a specific spot in order to calculate average ratings for a spot
    List<Trip> findBySpot_SpotId(long id);

    // For when all we want is the average we can let SQL deal with the calculation
    @Query("SELECT AVG(t.surfRating) FROM Trip t WHERE t.spot.id = :spotId")
    Double findAverageSurfRatingBySpotId(@Param("spotId") long spotId);

    // For when all we want is the average we can let SQL deal with the calculation
    @Query("SELECT AVG(t.infoRating) FROM Trip t WHERE t.spot.id = :spotId")
    Double findAverageInfoRatingBySpotId(@Param("spotId") long spotId);
}
