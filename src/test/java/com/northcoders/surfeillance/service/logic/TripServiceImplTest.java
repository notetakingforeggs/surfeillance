package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.SkillLevel;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.NewTripDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.TripUpdatesDTO;
import com.northcoders.surfeillance.model.dto.UserUpdatesDTO;
import com.northcoders.surfeillance.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TripServiceImplTest {

    @Mock
    TripRepository mockRepository;

    @InjectMocks
    TripServiceImpl tripService;

    Trip tripOne;
    Trip tripTwo;
    List<Trip> trips;
    NewTripDTO newTrip;

    @BeforeEach
    void setup() {
        tripOne = new Trip(1L,
                new AppUser(1L, "ste", "a surfer", "uk", SkillLevel.BEGINNER, "", "", ""),
                new Spot(),
                LocalDate.now(),
                1.0, "NW", 0.5, 1.5, "NE", 4, 1.1);
        tripTwo = new Trip(2L,
                new AppUser(1L, "ste", "a surfer", "uk", SkillLevel.BEGINNER, "", "", ""),
                new Spot(),
                LocalDate.now(),
                1.0, "NW", 0.5, 1.5, "NE", 4, 1.1);
        trips = new ArrayList<>();
        trips.add(tripOne);
        trips.add(tripTwo);
        newTrip = new NewTripDTO(
                new AppUser(1L, "ste", "a surfer", "uk", SkillLevel.BEGINNER, "", "", ""),
                new Spot(),
                LocalDate.now(),
                1.0, "NW", 0.5, 1.5, "NE", 4, 1.1);
    }

    @Test
    void getAllTrips() {

        when(mockRepository.findByUserId(1L)).thenReturn(trips);

        List<TripDTO> tripDTOList = tripService.getAllTripsByUser(1);

        verify(mockRepository, times(1)).findByUserId(1L);
        assertEquals(tripDTOList.getFirst().getClass(), TripDTO.class);
        assertEquals(2, tripDTOList.size());
        assertEquals("ste", tripDTOList.getFirst().getAppUserDTO().getUserName());
    }

    @Test
    void createTripCreatesTripFromNewTripDTO() {
        when(mockRepository.save(any(Trip.class))).thenReturn(tripOne);

        Trip createdTrip = tripService.createTrip(newTrip);

        verify(mockRepository, times(1)).save(any(Trip.class));
        assertNotNull(createdTrip);
        assertEquals("ste", createdTrip.getUser().getUserName());
        assertNull(createdTrip.getSurfRating());
        assertNull(createdTrip.getInfoRating());
    }

    @Test
    void updateTrip() {

        TripUpdatesDTO updates = new TripUpdatesDTO(3, 4);

        when(mockRepository.existsById(1)).thenReturn(true);
        when(mockRepository.findById(1)).thenReturn(Optional.of(tripOne));

        Trip result = tripService.updateTrip(1, updates);

        assertNotNull(result);
        assertEquals(3, result.getSurfRating());
        assertEquals(4, result.getInfoRating());
        verify(mockRepository, times(1)).existsById(1);
        verify(mockRepository, times(1)).save(any(Trip.class));
        verify(mockRepository, times(1)).findById(1);
    }

    @Test
    void updateUserCanNotUpdateDoesNotExist() {
        TripUpdatesDTO updates = new TripUpdatesDTO(3, 4);

        when(mockRepository.existsById(1)).thenReturn(false);
        assertNull(tripService.updateTrip(1, updates));
        verify(mockRepository, times(1)).existsById(1);
        verify(mockRepository, times(0)).save(any(Trip.class));
        verify(mockRepository, times(0)).findById(1);
    }
}



















