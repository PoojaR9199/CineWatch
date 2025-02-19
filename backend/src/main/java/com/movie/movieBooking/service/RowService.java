package com.movie.movieBooking.service;

import com.movie.movieBooking.dto.RowDTO;
import com.movie.movieBooking.dto.ScreenDTO;
import com.movie.movieBooking.model.Row;
import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.model.Seat;
import com.movie.movieBooking.repository.RowRepository;
import com.movie.movieBooking.repository.ScreenRepository;
import com.movie.movieBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RowService {
    @Autowired
    RowRepository rowRepository;
    @Autowired
    ScreenService screenService;
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    ScreenRepository screenRepository;
//    public RowDTO addRow(Row row) {
////        Optional<Row> existingRow = rowRepository.findByRowNameAndScreen_ScreenId(row.getRowName(),row.getScreen().getScreenId());
////        if(existingRow.isPresent()){
////            throw new RuntimeException("Row name "+row.getRowName()+" already exiting ");
////        }
////        Row savedRow = rowRepository.save(row);
////        Optional<Screen> screenDTO=screenService.getScreenById(savedRow.getScreen().getScreenId());
////        return new RowDTO(savedRow,screenDTO);
//        // Validate if the screen exists
//        Screen screen = screenService.getScreenById(row.getScreen().getScreenId())
//                .orElseThrow(() -> new RuntimeException("Screen not found with ID: " + row.getScreen().getScreenId()));
//
//        // Check if a row with the same name already exists in this screen
//        Optional<Row> existingRow = rowRepository.findByRowNameAndScreen_ScreenId(row.getRowName(), row.getScreen().getScreenId());
//        if (existingRow.isPresent()) {
//            throw new RuntimeException("Row name " + row.getRowName() + " already exists in this screen");
//        }
//
//        // Save the new row
//        row.setScreen(screen); // Ensure the row is properly associated with the screen
//        Row savedRow = rowRepository.save(row);
//
//        // Convert Screen to ScreenDTO
//        ScreenDTO screenDTO = new ScreenDTO(screen);
//
//        // Return DTO with saved row
//        return new RowDTO(savedRow, Optional.of(screenDTO));
//    }

    public List<RowDTO> addRowsWithSeats(String screenId, int numRows, int numSeatsPerRow, BigDecimal seatPrice) {
        System.out.println(numSeatsPerRow);
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        List<RowDTO> savedRows = new ArrayList<>();
        int existingRowCount = rowRepository.countByScreen_ScreenId(screenId);

        for (int i = 0; i < numRows; i++) {
            String rowName = String.valueOf((char) ('A' + existingRowCount + i)); // Generate 'A', 'B', 'C' dynamically

            Row row = new Row();
            row.setRowId(UUID.randomUUID().toString());
            row.setRowName(rowName);
            row.setSeatPrice(seatPrice);
            row.setScreen(screen);
            row = rowRepository.save(row);

            List<Seat> seats = new ArrayList<>();
            for (int j = 1; j <= numSeatsPerRow; j++) {
                Seat seat = new Seat();
                seat.setSeatId(UUID.randomUUID().toString());
                seat.setSeatNumber(rowName + j); // Generates A1, A2, ..., B1, B2, ...
                seat.setStatus(Seat.SeatStatus.AVAILABLE);
                seat.setRow(row);
                seats.add(seat);
                System.out.println(seats);
            }

            seatRepository.saveAll(seats);
            row.setSeats(seats);
            savedRows.add(new RowDTO(row));
        }

        return savedRows;
    }

}
