package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.UserUpdatesDTO;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppUserDTO> getUserById(@PathVariable int id) {
        AppUserDTO user = userService.getUserById(id);
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<AppUser> updateUser(@RequestBody UserUpdatesDTO userUpdates, @PathVariable int id) {
        AppUser updatedUser = userService.updateUser(id, userUpdates);
        if (updatedUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Update Failed");
        } else {
            return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping(value = "/trips/{userid}")
    public ResponseEntity<List<TripDTO>> getTripsByUser(@PathVariable int userid) {
        List<TripDTO> tripList = tripService.getAllTripsByUser(userid);
        if(tripList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No content found");
        } else {
            return new ResponseEntity<>(tripList, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/trips/add")
//    public void addTrip(@RequestBody TripDTO tripDTO) {
    public void addTrip() {
        // create a new trip for a user based on some appropriate DTO
    }

    @PutMapping(value = "/trips/{id}")
    public void updateTrip() {
//    public void updateTrip(@RequestBody TripDTO tripDTO) {
        // Updates a trip's info
        // primarily to add ratings
        // May or may not use the same DTO as addTrip().
    }




}
