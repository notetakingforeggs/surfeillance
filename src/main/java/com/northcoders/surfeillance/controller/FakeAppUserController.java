package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.FakeAppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FakeAppUserController {

    @GetMapping
    public ResponseEntity<List<FakeAppUser>> getFakeUser(){

    }

}
