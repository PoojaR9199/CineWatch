package com.movie.movieBooking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "theatres")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String theatreId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Screen> screens;

    public String getTheatreId() {
        return theatreId;
    }

    @PrePersist  //a lifecycle callback that executes before inserting a new record into the database.
    public void prePersist() {
        this.theatreId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId='" + theatreId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", screens=" + screens +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
