package com.movie.movieBooking.controller;

import com.movie.movieBooking.dto.RowDTO;
import com.movie.movieBooking.dto.RowRequest;
import com.movie.movieBooking.model.Row;
import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/row")
public class RowController {

    @Autowired
    RowService rowService;
//        @PostMapping("/addRow")
//        private ResponseEntity<?> addRow(@RequestBody Row row){
//            try {
//                RowDTO existingRow=rowService.addRow(row);
//
//                return ResponseEntity.status(HttpStatus.CREATED).body(existingRow);
//            }catch (Exception ex){
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }




//    @PostMapping("/add")
//    public ResponseEntity<List<Row>> addRows(@RequestBody RowRequest request) {
//        List<Row> savedRows = rowService.addRowsWithSeats(
//                request.getScreenId(),
//                request.getNumRows(),
//                request.getNumSeatsPerRow(),
//                request.getSeatPrice()
//        );
//        return ResponseEntity.ok(savedRows);
//    }

    @PostMapping("/add")
    public ResponseEntity<List<RowDTO>> addRows(@RequestBody RowRequest rowRequest) {
        List<RowDTO> newRows = rowService.addRowsWithSeats(
                rowRequest.getScreenId(),
                rowRequest.getNumRows(),
                rowRequest.getNumSeatsPerRow(),
                rowRequest.getSeatPrice()
        );

        return ResponseEntity.ok(newRows);
    }
}


