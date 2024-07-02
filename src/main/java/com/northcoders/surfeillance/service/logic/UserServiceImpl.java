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
    public AppUser createUser(AppUser appUser) {
        return userRepository.save(appUser);
    }


    @Override
    public boolean updateUpset(int id, AppUser userUpdates) {
        if (!userRepository.existsById(id)) {
            return false;
        } else {
            Optional<AppUser> optionalUserToUpdate = userRepository.findById(id);
            if (optionalUserToUpdate.isEmpty()) return false;
            AppUser updatedUser = optionalUserToUpdate.get();
            applyUpdate(updatedUser, userUpdates);
            userRepository.save(updatedUser);
            return true;
        }
    }

    private void applyUpdate(AppUser appUser, AppUser userUpdates) {
        appUser.setUserName(userUpdates.getUserName());
        appUser.setProfileText(userUpdates.getProfileText());
        appUser.setLocation(userUpdates.getLocation());
        appUser.setSkillLevel(userUpdates.getSkillLevel());
    }
}
