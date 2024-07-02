package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;

public interface UserService {
    AppUserDTO getUserById(int id);
    boolean createUser(AppUser appUser);
    boolean updateUpset(AppUser userUpdates);
}
