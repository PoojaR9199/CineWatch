package com.movie.movieBooking.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

@Entity
@Table(name = "`show`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ShowTimes {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String showId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(nullable = false)
    private LocalTime showTime;

    @Column(nullable = false)
    private LocalDate date;

}
