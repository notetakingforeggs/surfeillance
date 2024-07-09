package com.northcoders.surfeillance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column
    private String userName;

    @Setter
    @Column
    private String googleId;

    @Setter
    @Column
    private String profileText;

    @Setter
    @Column
    private String location;

    @Setter
    @Column
    private SkillLevel skillLevel;

    @Setter
    @Column
    private String imageUrl;

    @Setter
    @Column
    private String email;

    @Setter
    @Column
    private String token;

    public AppUser(String userName, String profileText, String location, SkillLevel skillLevel) {
        this.userName = userName;
        this.profileText = profileText;
        this.location = location;
        this.skillLevel = skillLevel;
    }

    public AppUser(String userName, String profileText, String location, SkillLevel skillLevel, String imageUrl, String email, String token) {
        this.userName = userName;
        this.profileText = profileText;
        this.location = location;
        this.skillLevel = skillLevel;
        this.imageUrl = imageUrl;
        this.email = email;
        this.token = token;
    }

    public AppUser(String userName, String googleId, String profileText, String location, SkillLevel skillLevel, String imageUrl, String email, String token) {
        this.userName = userName;
        this.googleId = googleId;
        this.profileText = profileText;
        this.location = location;
        this.skillLevel = skillLevel;
        this.imageUrl = imageUrl;
        this.email = email;
        this.token = token;
    }
}
