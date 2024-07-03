package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.SkillLevel;
import lombok.Data;

@Data
public class AppUserDTO {

    private long id;
    private String userName;
    private String profileText;
    private String location;
    private SkillLevel skillLevel;
    private String imageUrl;
    private String email;
    private String token;

    public AppUserDTO(AppUser appUser) {
        this.id = appUser.getId();
        this.userName = appUser.getUserName();
        this.profileText = appUser.getProfileText();
        this.location = appUser.getLocation();
        this.skillLevel = appUser.getSkillLevel();
        this.imageUrl = appUser.getImageUrl();
        this.email = appUser.getEmail();
        this.token = appUser.getToken();
    }

}
