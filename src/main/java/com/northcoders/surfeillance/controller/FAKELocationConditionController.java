package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.FakeLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


    @RestController
    @RequestMapping("fakelocationdata")
    public class FAKELocationConditionController {

        @GetMapping
        public ResponseEntity<List<FakeLocation>> getFakeLocation() {

            ArrayList<FakeLocation> locations = new ArrayList<FakeLocation>( List.of(
                    new FakeLocation("fistral", "its a beachbreak", "2oclock", "50", "50", "GMT", 1d, "NW", 11d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock"),
                    new FakeLocation("st Ives", "its another beachbreak", "2oclock", "50", "50", "GMT", 2d, "NW", 10d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock"),
                    new FakeLocation("cayton bay", "its a rocky point", "2oclock", "50", "50", "GMT", 2d, "NW", 10d, 14d, 20d, 3.8, "twooclock", 2.8, "8oclock")
            ));

            return new ResponseEntity<>(locations, HttpStatus.OK);
        }
        @PostMapping("/addfaketrip")
        public ResponseEntity<FakeLocation> postFakeLocation(@RequestBody FakeLocation postFakeLocation) { // The @RequestBody annotation maps the JSON body of the HTTP POST request to the fakeLocation object
            System.out.println(postFakeLocation.toString());
            return new ResponseEntity<FakeLocation>(postFakeLocation, HttpStatus.CREATED);
        }


    }
