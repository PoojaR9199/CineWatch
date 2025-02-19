package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.Seat;

public class SeatDTO {
    private String seatId;
    private String seatNumber;
    private String status;

    public SeatDTO(Seat seat) {
        this.seatId = seat.getSeatId();
        this.seatNumber = seat.getSeatNumber();
        this.status = seat.getStatus().name();
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }
}
