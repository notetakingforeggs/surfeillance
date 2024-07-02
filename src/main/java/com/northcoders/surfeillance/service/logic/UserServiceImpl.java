package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public AppUserDTO getUserById(int id) {
        Optional<AppUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        } else {
            return new AppUserDTO(optionalUser.get());
        }

    }

    @Override
    public boolean createUser(AppUser appUser) {
        return false;
    }

    @Override
    public boolean updateUpset(AppUser userUpdates) {
        return false;
    }
}
