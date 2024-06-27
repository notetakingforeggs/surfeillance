package com.northcoders.surfeillance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;


import java.time.LocalDate;

@Entity
@Getter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tripId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "spotId", nullable = false)
    private Spot spot;

    @Setter
    @Column
    @Min(1)
    @Max(5)
    private int surfRating;

    @Setter
    @Column
    @Min(1)
    @Max(5)
    private int infoRating;

    @Column
    private LocalDate date;

    public Trip(AppUser user, Spot spot, LocalDate date) {
        this.user = user;
        this.spot = spot;
        this.date = date;
    }
}
