package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.repository.SpotRepository;
import org.assertj.core.internal.Conditions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock
    SpotRepository spotRepository;

    @Mock
    ConditionsBuilder conditionsBuilder;

    @Mock
    List<Spot> spotList;

    @Mock
    Iterator<Spot> mockIterator;

    @Mock
    Spot spotOne;

    @Mock
    Spot spotTwo;

    // Test class
    @InjectMocks
    ServiceImpl service;


    @Test
    void getConditions() {
        spotList.add(spotOne);
        spotList.add(spotTwo);

        when(spotRepository.findAll()).thenReturn(spotList);

        when(spotList.iterator()).thenReturn(mockIterator);

        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn(spotOne, spotTwo);

        ConditionsDTO conditionOne = new ConditionsDTO(null, null, null, null);
        ConditionsDTO conditionTwo = new ConditionsDTO(null, null, null, null);

        when(conditionsBuilder.conditionBuilder(spotOne)).thenReturn(conditionOne);
        when(conditionsBuilder.conditionBuilder(spotTwo)).thenReturn(conditionTwo);

        List<ConditionsDTO> actualList = service.getConditions();

        assertEquals(2, actualList.size());
        verify(spotRepository, times(1)).findAll();
        verify(conditionsBuilder, times(2)).conditionBuilder(any(Spot.class));

    }
}