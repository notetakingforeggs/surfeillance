package com.northcoders.surfeillance.model.dto;

import com.northcoders.surfeillance.model.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class NewUserDTO {
    String userName;
    String profileText;
    String location;
    SkillLevel skillLevel;
    String imageUrl;
    String email;
    String token;
}
