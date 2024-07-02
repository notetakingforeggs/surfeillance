package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;

public interface UserService {
    AppUserDTO getUserById(int id);
    AppUser createUser(AppUser appUser);
    boolean updateUpset(int id, AppUser userUpdates);
}
