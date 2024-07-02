package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.SkillLevel;
import lombok.Data;

@Data
public class AppUserDTO {

    private long id;
    private String username;
    private String profileText;
    private String lcoation;
    private SkillLevel skillLevel;

}
