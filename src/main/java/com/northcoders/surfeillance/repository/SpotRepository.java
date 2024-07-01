package com.northcoders.surfeillance.repository;

import com.northcoders.surfeillance.model.Spot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends CrudRepository<Spot, Integer> {

    // exists as a standard CrudRepository method
    // find a spot by ID (not sure we will use that at all)
    // existsByID()
    // findAll()
    // save()

    // As a beyond MVP method we may need a function that will return the x closest spots to a given search criteria?
        // If we don't use that we would either pull everything and sort them or pull something based on a given distance
        // probably want to use pagination at that point
}
