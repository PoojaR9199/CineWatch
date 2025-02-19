package com.movie.movieBooking.service;

import com.movie.movieBooking.model.Theatre;
import com.movie.movieBooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre registerTheatre(Theatre theatre) {
        Optional<Theatre> existingTheatre = theatreRepository.findByNameAndLocation(theatre.getName(),theatre.getLocation());
        if(existingTheatre.isPresent()) {
            throw new RuntimeException("Theatre with name " + theatre.getName() + " already exists! at location "+theatre.getLocation());
        }

        return theatreRepository.save(theatre);
    }
    public Optional<List<Theatre>> getAllTheatres() {
        Optional<List<Theatre>> allTheatres = Optional.of(theatreRepository.findAll());
        return allTheatres;
    }

    public Theatre getTheatreById(String id) {
//        System.out.println("Service : "+id);
//        Optional<Theatre> theatre = theatreRepository.findById(id);
//        System.out.println("Theatre : "+theatre);
//        if(theatre.isEmpty()){
//            throw new RuntimeException("No theatre found");
//        }
//        return theatre;
        return theatreRepository.findById(id).orElseThrow(() -> new RuntimeException("No theatre found"));
    }


}
