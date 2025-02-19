package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.Row;
import com.movie.movieBooking.model.Seat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class RowDTO {
    private String rowId;
    private String rowName;
    private BigDecimal seatPrice;
//    private Optional<ScreenDTO> screenDTO;
    private List<SeatDTO> seats;

    public RowDTO(Row row) {
        this.rowId = row.getRowId();
        this.rowName = row.getRowName();
        this.seatPrice = row.getSeatPrice();
//        this.screenDTO = screenDTO; // No fetching inside DTO
        this.seats = row.getSeats().stream().map(SeatDTO::new).toList();
    }

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

//    public Optional<ScreenDTO> getScreenDTO() {
//        return screenDTO;
//    }
//
//    public void setScreenDTO(Optional<ScreenDTO> screenDTO) {
//        this.screenDTO = screenDTO;
//    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }
}
