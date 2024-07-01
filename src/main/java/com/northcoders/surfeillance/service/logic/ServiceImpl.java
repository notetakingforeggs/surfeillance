package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service{

    @Autowired
    SpotRepository spotRepository;

    @Autowired
    ConditionsBuilder conditionsBuilder;

    @Override
    public List<ConditionsDTO> getConditions() {
        List<Spot> allSpots = (List<Spot>) spotRepository.findAll();
        List<ConditionsDTO> conditions = new ArrayList<>();

        for (Spot spot : allSpots) {
            conditions.add(conditionsBuilder.conditionBuilder(spot));
        }

        return conditions;
    }
}
