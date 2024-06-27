package com.northcoders.surfeillance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Setter
    @Column
    private String profileText;

    @Setter
    @Column
    private String location;

    @Setter
    @Column
    private SkillLevel skillLevel;
}
