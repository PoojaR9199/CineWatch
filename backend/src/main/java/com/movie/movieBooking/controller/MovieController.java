package com.movie.movieBooking.controller;

import com.movie.movieBooking.model.Movie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @PostMapping("/addMovie")
    private void addMovie(@RequestBody Movie movie){

    }
}
