package com.northcoders.surfeillance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/spots")
public class SpotController {

    /*
    Framework for the spot controller
    Defined all methods as void although that won't be the case
    Used invalid DTO names so that it throws an error
    and doesn't cause us issues down the line
 */

    //    @Autowired
    //    SpotService spotService;
    //    Some as of yet undefined service class will presumably
    //    be the main service class to each controller

    @GetMapping
    public void getAllSpots() {
        // Returns a list of spots with all needed details
        // as some form of DTO.
        // Might need to find a way to trim it down to a smaller list at
        // some point but probably not an issue for now.
    }

    @GetMapping(value ="/{id}")
    public void getSpot() {
        // I don't think it's real but I'm putting it here to acknowledge
        // that we may allow searching by name or lat/long query params
        // at some points
    }
}
