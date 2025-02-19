package com.movie.movieBooking.controller;

import com.movie.movieBooking.dto.ScreenDTO;
import com.movie.movieBooking.dto.TheatreDTO;
import com.movie.movieBooking.model.Theatre;
import com.movie.movieBooking.model.User;
import com.movie.movieBooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;
    @PostMapping("/addTheatre")
    private ResponseEntity<?> addTheatre(@RequestBody Theatre theatre){
        try {
            Theatre registeredTheatre = theatreService.registerTheatre(theatre);
            return ResponseEntity.status(HttpStatus.CREATED).body("Theatre registered successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/allTheatres")
    private ResponseEntity<?> getAllTheatres(){
        try {
            Optional<List<Theatre>> registeredTheatre = theatreService.getAllTheatres();
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredTheatre);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/getTheatreById")
    private ResponseEntity<?> getById(@RequestParam("theatreId") String id){

        try {
            Optional<Theatre> getTheatre = Optional.ofNullable(theatreService.getTheatreById(id));
            return ResponseEntity.status(HttpStatus.CREATED).body(getTheatre);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    //This also works
//@GetMapping("/getTheatreById")
//public ResponseEntity<?> getTheatreById(@RequestParam("theatreId") String theatreId) {
//    try {
//        Optional<Theatre> theatreOptional = Optional.ofNullable(theatreService.getTheatreById(theatreId));
//
//        if (theatreOptional.isPresent()) {
//            TheatreDTO theatreDTO = new TheatreDTO(theatreOptional);
//            System.out.println("Theatre dto : "+theatreDTO);
//            return ResponseEntity.status(HttpStatus.OK).body(theatreDTO);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Theatre not found");
//        }
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
//    }
//}


}
