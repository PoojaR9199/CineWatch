package com.movie.movieBooking.repository;

import com.movie.movieBooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,String> {
    Optional<Theatre> findByNameAndLocation(String name, String location);
}
