package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.FakeAppUser;
import com.northcoders.surfeillance.model.FakeLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fakeusers")
public class FakeAppUserController {

      List<Integer> faveLocationIds = new ArrayList<Integer>(List.of(1,2,3));


    @GetMapping
    public ResponseEntity<FakeAppUser> getFakeUser(){
    return new ResponseEntity<>(new FakeAppUser(1, "keanu reeves", "hawaii",faveLocationIds, 5 ), HttpStatus.OK);
    }

}