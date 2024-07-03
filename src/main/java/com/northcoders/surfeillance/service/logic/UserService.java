package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;

public interface UserService {
    AppUserDTO getUserById(int id);
    AppUser createUser(NewUserDTO newUser);
    boolean updateUser(int id, AppUser userUpdates);
}
