package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;
import com.northcoders.surfeillance.model.dto.UserUpdatesDTO;

public interface UserService {
    AppUserDTO getUserById(int id);
    AppUser createUser(NewUserDTO newUser);
    AppUser updateUser(int id, UserUpdatesDTO userUpdates);
}
