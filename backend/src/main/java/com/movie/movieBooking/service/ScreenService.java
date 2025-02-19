package com.movie.movieBooking.service;

import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.model.Theatre;
import com.movie.movieBooking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScreenService {
    @Autowired
    ScreenRepository screenRepository;
    public Screen addScreen(Screen screen){
        Optional<Screen> existingScreen = screenRepository.findByScreenNameAndTheatre(screen.getScreenName(),screen.getTheatre());
        if(existingScreen.isPresent()) {
            throw new RuntimeException("Screen with name " + screen.getScreenName() + " already exists at given Theatre ");
        }

        return screenRepository.save(screen);  // Save the new screen

    }

    public Optional<Screen> getScreenById(String id) {
        return screenRepository.findById(id);
    }
}
