package com.northcoders.surfeillance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.SkillLevel;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService mockService;

    @InjectMocks
    UserController userController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(userController).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void getUserByIdReturnsUser() throws Exception {
        AppUserDTO user = new AppUserDTO(new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER));

        when(mockService.getUserById(1)).thenReturn(user);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileText").value("surfer"));

        verify(mockService, times(1)).getUserById(1);
    }

    @Test
    void getUserByIdFailsToReturnUser() throws Exception {
        when(mockService.getUserById(1)).thenReturn(null);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.status().reason("User not found"));

        verify(mockService, times(1)).getUserById(1);
    }

    @Test
    void createUserCreatesUserAndConfirms() throws Exception {
        NewUserDTO newUser = new NewUserDTO("ste", "surfer", "UK", SkillLevel.BEGINNER);
        AppUser createdUser = new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER);

        when(mockService.createUser(newUser)).thenReturn(createdUser);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.post("/api/v1/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profileText").value("surfer"));

        verify(mockService, times(1)).createUser(newUser);
    }

    @Test
    void createUserDoesNotCreateUserAndConfirms() throws Exception {
        NewUserDTO newUser = new NewUserDTO("ste", "surfer", "UK", SkillLevel.BEGINNER);

        when(mockService.createUser(newUser)).thenReturn(null);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/users/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isNotAcceptable())
                .andExpect(MockMvcResultMatchers.status().reason("User creation failed"));

        verify(mockService, times(1)).createUser(newUser);
    }

//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void getTripsByUser() {
//    }
//
//    @Test
//    void getTripById() {
//    }
//
//    @Test
//    void addTrip() {
//    }
//
//    @Test
//    void updateTrip() {
//    }
}