package com.movie.movieBooking.repository;

import com.movie.movieBooking.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RowRepository extends JpaRepository<Row,String> {
    Optional<Row> findByRowNameAndScreen_ScreenId(String rowName,String screenId);
    int countByScreen_ScreenId(String screenId);
}
