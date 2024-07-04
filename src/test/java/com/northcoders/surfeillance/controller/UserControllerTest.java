package com.northcoders.surfeillance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.SkillLevel;
import com.northcoders.surfeillance.model.Spot;
import com.northcoders.surfeillance.model.Trip;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;
import com.northcoders.surfeillance.model.dto.TripDTO;
import com.northcoders.surfeillance.model.dto.UserUpdatesDTO;
import com.northcoders.surfeillance.service.logic.TripService;
import com.northcoders.surfeillance.service.logic.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService mockUserService;

    @Mock
    TripService mockTripService;

    @InjectMocks
    UserController userController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    TripDTO tripOne;
    TripDTO tripTwo;
    List<TripDTO> trips;

    @BeforeEach
    void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(userController).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        trips = new ArrayList<>();
        tripOne = new TripDTO(new Trip(1L,
                new AppUser(1L, "ste", "a surfer", "uk", SkillLevel.BEGINNER, "", "", ""),
                new Spot(),
                LocalDate.now(),
                1.0, "NW", 0.5, 1.5, "NE", 4, 1.1));
        tripTwo = new TripDTO(new Trip(2L,
                new AppUser(1L, "ste", "a surfer", "uk", SkillLevel.BEGINNER, "", "", ""),
                new Spot(),
                LocalDate.now(),
                1.1, "NE", 0.5, 1.5, "NE", 4, 1.1));
        trips.add(tripOne);
        trips.add(tripTwo);
    }

    @Test
    void getUserByIdReturnsUser() throws Exception {
        AppUserDTO user = new AppUserDTO(new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER, "", "", ""));

        when(mockUserService.getUserById(1)).thenReturn(user);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileText").value("surfer"));

        verify(mockUserService, times(1)).getUserById(1);
    }

    @Test
    void getUserByIdFailsToReturnUser() throws Exception {
        when(mockUserService.getUserById(1)).thenReturn(null);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.status().reason("User not found"));

        verify(mockUserService, times(1)).getUserById(1);
    }

    @Test
    void createUserCreatesUserAndConfirms() throws Exception {
        NewUserDTO newUser = new NewUserDTO("ste", "surfer", "UK", SkillLevel.BEGINNER, "", "", "");
        AppUser createdUser = new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER, "", "", "");

        when(mockUserService.createUser(newUser)).thenReturn(createdUser);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.post("/api/v1/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileText").value("surfer"));

        verify(mockUserService, times(1)).createUser(newUser);
    }

    @Test
    void createUserDoesNotCreateUserAndConfirms() throws Exception {
        NewUserDTO newUser = new NewUserDTO("ste", "surfer", "UK", SkillLevel.BEGINNER, "", "", "");

        when(mockUserService.createUser(newUser)).thenReturn(null);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/users/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isNotAcceptable())
                .andExpect(MockMvcResultMatchers.status().reason("User creation failed"));

        verify(mockUserService, times(1)).createUser(newUser);
    }

    @Test
    void updateUserShouldUpdateUser() throws Exception {
        AppUser existingUser = new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER, "", "", "");
        UserUpdatesDTO userUpdates = new UserUpdatesDTO("", "", "", null, "image.jpg", "email@email.co.uk", "tokenString");
        AppUser updatedUser = new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER, "image.jpg", "email@email.co.uk", "tokenString");

        when(mockUserService.updateUser(1, userUpdates)).thenReturn(updatedUser);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.put("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(userUpdates)))
                        .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.imageUrl").value("image.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email@email.co.uk"));

        verify(mockUserService, times(1)).updateUser(1, userUpdates);
    }

    @Test
    void updateUserShouldReportFailure() throws Exception {
        UserUpdatesDTO userUpdates = new UserUpdatesDTO("", "", "", null, "image.jpg", "email@email.co.uk", "tokenString");

        when(mockUserService.updateUser(1, userUpdates)).thenReturn(null);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.put("/api/v1/users/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(userUpdates)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.status().reason("User Update Failed"));

        verify(mockUserService, times(1)).updateUser(1, userUpdates);
    }


    @Test
    void getTripsByUserShouldReturnUserTrips() throws Exception {
        when(mockTripService.getAllTripsByUser(1)).thenReturn(trips);

        System.out.println(tripOne.toString());
        System.out.println(tripTwo.toString());

        this.mockMvcController.perform(
            MockMvcRequestBuilders.get("/api/v1/users/trips/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].appUserDTO.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].appUserDTO.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].waveHeight").value(1.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].waveHeight").value(1.1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].waveDirection").value("NW"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].waveDirection").value("NE"));

        verify(mockTripService, times(1)).getAllTripsByUser(1);
    }


    @Test
    void addTrip() {
    }

    

//    @Test
//    void updateTrip() {
//    }
}