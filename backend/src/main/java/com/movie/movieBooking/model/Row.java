package com.movie.movieBooking.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "`rows`")
public class Row {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String rowId;

    @Column(nullable = false, length = 10)
    private String rowName;

    @Column(nullable = false)
    private BigDecimal seatPrice;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private List<Seat> seats;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public BigDecimal getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(BigDecimal seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    @PrePersist()
    public void prePersist() {
        this.rowId = UUID.randomUUID().toString();
    }
}
