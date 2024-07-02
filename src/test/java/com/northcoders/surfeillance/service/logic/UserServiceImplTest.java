package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.SkillLevel;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    AppUser appUser;

    @BeforeEach
    void setup() {
        appUser = new AppUser(1L, "ste", "surfer", "UK", SkillLevel.BEGINNER);
    }

    @Test
    void getUserByIdReturnsUser() {
        when(userRepository.findById(1)).thenReturn(Optional.of(appUser));

        AppUserDTO actualUserDTO = userService.getUserById(1);
        verify(userRepository, times(1)).findById(1);
        assertNotNull(actualUserDTO);
        assertEquals("ste", actualUserDTO.getUsername());
    }

    @Test
    void getUserByIdReturnsNull() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        AppUserDTO actualUserDTO = userService.getUserById(1);
        verify(userRepository, times(1)).findById(1);
        assertNull(actualUserDTO);
    }

    @Test
    void createUserCreatesUser() {
        when(userRepository.save(appUser)).thenReturn(appUser);

        AppUser savedUser = userService.createUser(appUser);

        verify(userRepository, times(1)).save(appUser);
        assertNotNull(savedUser);
        assertEquals("ste", savedUser.getUserName());
    }

    @Test
    void updateUserUpdatesUserAndConfirms() {
        when(userRepository.existsById(1)).thenReturn(true);
        when(userRepository.findById(1)).thenReturn(Optional.of(appUser));

        boolean result = userService.updateUser(1, new AppUser());

        assertTrue(result);
        verify(userRepository, times(1)).existsById(1);
        verify(userRepository, times(1)).save(any(AppUser.class));
        verify(userRepository, times(1)).findById(1);

    }

    @Test
    void updateUserCanNotUpdateDoesNotExist() {
        when(userRepository.existsById(1)).thenReturn(false);
        assertFalse(userService.updateUser(1, new AppUser()));
        verify(userRepository, times(1)).existsById(1);
        verify(userRepository, times(0)).save(any(AppUser.class));
        verify(userRepository, times(0)).findById(1);
    }


}