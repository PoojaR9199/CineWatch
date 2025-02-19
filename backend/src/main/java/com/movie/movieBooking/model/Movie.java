package com.movie.movieBooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String movieId;

    @Column(nullable = false, length = 10)
    private String movieName;

    @JdbcTypeCode(SqlTypes.JSON)  // Stores genres as JSON
    @Column(columnDefinition = "JSON")
    private List<String> genres; // Example: ["Action", "Sci-Fi"]

    @Column(nullable = false, length = 50)
    private String language;

    @Column(nullable = false, length = 100)
    private String posterUrl;

    @Column(nullable = false,length = 200)
    private String description; // Duration in minutes

    @Column(nullable = false)
    private int duration; // Duration in minutes

}
