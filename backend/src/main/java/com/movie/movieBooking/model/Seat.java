package com.movie.movieBooking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "seats")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String seatId;

    @Column(nullable = false, length = 10)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "row_id", nullable = false)
    private Row row;

    public enum SeatStatus {
        AVAILABLE, BOOKED, OUT_OF_SERVICE
    }

    @PrePersist
    public void prePersist() {
        this.seatId = UUID.randomUUID().toString();
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }
}
