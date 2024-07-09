package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import com.northcoders.surfeillance.model.dto.NewUserDTO;
import com.northcoders.surfeillance.model.dto.UserUpdatesDTO;
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
    public AppUser createUser(NewUserDTO newUser) {
        return userRepository.save(new AppUser(
                newUser.getUserName(),
                newUser.getProfileText(),
                newUser.getLocation(),
                newUser.getSkillLevel(),
                newUser.getEmail(),
                newUser.getGoogleId()
        ));
    }


    @Override
    public AppUser updateUser(int id, UserUpdatesDTO userUpdates) {
        if (!userRepository.existsById(id)) {
            return null;
        } else {
            Optional<AppUser> optionalUserToUpdate = userRepository.findById(id);
            if (optionalUserToUpdate.isEmpty()) return null;
            AppUser updatedUser = optionalUserToUpdate.get();
            applyUpdate(updatedUser, userUpdates);
            userRepository.save(updatedUser);
            return updatedUser;
        }
    }

    private void applyUpdate(AppUser appUser, UserUpdatesDTO userUpdates) {
        if(userUpdates.getUserName() != null && !userUpdates.getUserName().isEmpty()) appUser.setUserName(userUpdates.getUserName());
        if(userUpdates.getProfileText() != null && !userUpdates.getProfileText().isEmpty()) appUser.setProfileText(userUpdates.getProfileText());
        if(userUpdates.getLocation() != null && !userUpdates.getLocation().isEmpty()) appUser.setLocation(userUpdates.getLocation());
        if(userUpdates.getSkillLevel() != null) appUser.setSkillLevel(userUpdates.getSkillLevel());
        if(userUpdates.getImageUrl() != null && !userUpdates.getImageUrl().isEmpty()) appUser.setImageUrl(userUpdates.getImageUrl());
    }
}
