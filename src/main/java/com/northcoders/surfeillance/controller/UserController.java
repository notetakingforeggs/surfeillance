package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.*;
import com.northcoders.surfeillance.service.logic.TripService;
import com.northcoders.surfeillance.service.logic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

/*
    Framework for the user controller (which will include /health)
    Defined all methods as void although that won't be the case
    Used invalid DTO names so that it throws an error
    and doesn't cause us issues down the line
 */

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable int userId) {
        AppUserDTO user = userService.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<AppUser> createUser(@RequestBody NewUserDTO newUser) {
        AppUser addedUser = userService.createUser(newUser);
        if (addedUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User creation failed");
        } else {
            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<AppUser> updateUser(@RequestBody UserUpdatesDTO userUpdates, @PathVariable int userId) {
        AppUser updatedUser = userService.updateUser(userId, userUpdates);
        if (updatedUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Update Failed");
        } else {
            return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping(value = "/trips/{userId}")
    public ResponseEntity<List<TripDTO>> getTripsByUser(@PathVariable int userId) {
        List<TripDTO> tripList = tripService.getAllTripsByUser(userId);
        if(tripList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No content found");
        } else {
            return new ResponseEntity<>(tripList, HttpStatus.OK);
        }
    }

    // For the below,
    // MAKE SURE TO USE THE CORRECT DTO OBJECTS

    @PostMapping(value = "/trips/add")
    public ResponseEntity<Trip> addTrip(@RequestBody NewTripDTO newTrip) {
        Trip createdTrip = tripService.createTrip(newTrip);
        if (createdTrip == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Trip Creation Failed");
        } else {
            return new ResponseEntity<>(createdTrip, HttpStatus.CREATED);
        }

    }

    @PutMapping(value = "/trips/{userId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable int userId, @RequestBody TripUpdatesDTO tripUpdates) {
        Trip updatedTrip = tripService.updateTrip(userId, tripUpdates);
        if (updatedTrip == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trip Update Failed");
        } else {
            return new ResponseEntity<>(updatedTrip, HttpStatus.ACCEPTED);
        }

    }




}
