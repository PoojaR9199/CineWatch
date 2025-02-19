package com.movie.movieBooking.controller;

import com.movie.movieBooking.dto.ScreenDTO;
import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.model.Theatre;
import com.movie.movieBooking.service.ScreenService;
import com.movie.movieBooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    @Autowired
    ScreenService screenService;

    @PostMapping("/addScreen")
    private ResponseEntity<?> addScreen(@RequestBody Screen screen){
        try {
            Screen registeredScreen = screenService.addScreen(screen);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/getScreen")
    private ResponseEntity<?> getScreenById(@RequestParam("screenId") String id){
        Optional<Screen> screen = screenService.getScreenById(id);
        ScreenDTO dto=new ScreenDTO(screen);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
