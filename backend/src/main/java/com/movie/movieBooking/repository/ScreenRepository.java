package com.movie.movieBooking.repository;

import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,String> {
    Optional<Screen> findByScreenNameAndTheatre(String screenName, Theatre theatre);

}
