package com.movie.movieBooking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "screens")
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonIgnoreProperties({"theatre"})
public class Screen {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String screenId;

    @Column(nullable = false, length = 50)
    private String screenName;

    @Column(nullable = false)
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    @JsonBackReference
    private Theatre theatre;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // Prevents serialization
    private List<Row> rows;

    @PrePersist()
    public void prePersist() {
        this.screenId = UUID.randomUUID().toString();
    }


    public String getScreenName() {
        return screenName;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}

