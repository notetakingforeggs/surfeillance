package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.SkillLevel;
import lombok.Data;

@Data
public class UserUpdatesDTO {

    private String userName;
    private String profileText;
    private String location;
    private SkillLevel skillLevel;
    private String imageUrl;
    private String email;
    private String token;

    public UserUpdatesDTO(String userName, String profileText, String location, SkillLevel skillLevel, String imageUrl, String email, String token) {
        this.userName = userName;
        this.profileText = profileText;
        this.location = location;
        this.skillLevel = skillLevel;
        this.imageUrl = imageUrl;
        this.email = email;
        this.token = token;
    }
}
