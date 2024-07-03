package com.northcoders.surfeillance.controller;

import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.service.logic.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("api/v1/conditions")
public class ConditionController {

    @Autowired
    ServiceImpl service;

    /*
    Framework for the spot controller
    Defined all methods as void although that won't be the case
    Used invalid DTO names so that it throws an error
    and doesn't cause us issues down the line
 */


    @GetMapping
    public ResponseEntity<List<ConditionsDTO>> getAllConditions() {
        List<ConditionsDTO> list = service.getConditions();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No content found");
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public void getCondition() {
        // I don't think it's real but I'm putting it here to acknowledge
        // that we may allow searching by name or lat/long query params
        // at some points
    }
}
