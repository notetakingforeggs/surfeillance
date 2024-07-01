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
    private String profileText;

    @Setter
    @Column
    private String location;

    @Setter
    @Column
    private SkillLevel skillLevel;
}
