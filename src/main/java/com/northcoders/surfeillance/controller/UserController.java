package com.northcoders.surfeillance.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

/*
    Framework for the user controller (which will include /health)
    Defined all methods as void although that won't be the case
    Used invalid DTO names so that it throws an error
    and doesn't cause us issues down the line
 */


//    @Autowired
//    UserService userService;
//    Some as of yet undefined service class will presumably
//    be the main service class to each controller

    @GetMapping(value = "/health")
    public void getHealth() {
        // Use Spring:Actuator to get a health endpoint
    }

    @GetMapping(value = "/{id}")
    public void getUserById(@PathVariable int id) {
        // Get a single user by id
                // auth issues aside
        // To populate their profile page
    }

    @PostMapping(value = "/add")
    public void createUser() {
//        public void createUser(@RequestBody -UserDTO newUser) {
        // Creates a new user after first time OAuth
        // Need to define the DTO used and what shape it is.
    }

    @PutMapping(value = "/{id}")
    public void updateUser() {
//    public void updateUser(@RequestBody -UserDTO updatedUser) {
        // Updates a user's profile (presumably from their profile page
        // May or may not use the same DTO as create.
    }

    @GetMapping(value = "/trips", params="userid")
    public void getTripsByUser(@RequestParam long userid) {
        // Returns a list of all trips for a user
        // In whatever shape is needed
    }

    @GetMapping(value = "/trips/{tripId}")
    public void getTripById() {
        // returns details of a specific trip
        // might already have what we need from the above
        // renders with the ability to edit if the trip belongs to the current user?
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
