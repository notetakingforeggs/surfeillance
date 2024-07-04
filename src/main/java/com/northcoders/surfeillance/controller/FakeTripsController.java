package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.FakeLocation;
import com.northcoders.surfeillance.model.FakeTrip;
import com.northcoders.surfeillance.model.Trip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("faketrips")
public class FakeTripsController {

    FakeLocation location1 = new FakeLocation("fistral", "its a beachbreak", "2oclock", "50", "50", "GMT", 1d, "NW", 11d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock");
    FakeLocation location2 = new FakeLocation("st Ives", "its another beachbreak", "2oclock", "50", "50", "GMT", 2d, "NW", 10d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock");
    FakeLocation location3 = new FakeLocation("cayton bay", "its a rocky point", "2oclock", "50", "50", "GMT", 2d, "NW", 10d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock");

    @GetMapping
    public ResponseEntity<List<FakeTrip>> getFakeTrip() {

        ArrayList<FakeTrip> trips = new ArrayList<FakeTrip>(List.of(
                new FakeTrip(1, 1, "7thmay3pm", location1 ),
                new FakeTrip(2, 2, "7thmay3pm", location2 ),
                new FakeTrip(3, 3, "7thmay3pm", location3 )
        ));

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<FakeTrip> editFakeTrip(@RequestBody FakeTrip editedTrip){
        System.out.println(editedTrip.toString());
        return new ResponseEntity<>(editedTrip, HttpStatus.OK);
    }
}



