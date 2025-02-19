package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.Screen;
import lombok.Data;

import java.util.Optional;

@Data
public class ScreenDTO {

    private String screenId;
    private String screenName;
    private int totalSeats;
    // Avoid including the full Theatre object
    private String theatreId;

    public ScreenDTO(Screen screen) {
        this.screenId = screen.getScreenId();
        this.screenName = screen.getScreenName();
        this.totalSeats = screen.getTotalSeats();
        this.theatreId = screen.getTheatre().getTheatreId();  // Only include the theatreId, not the whole theatre object
    }

    //While fetching the single Screen need the Theatre
    public ScreenDTO(Optional<Screen> screen) {
        if (screen.isPresent()){
            Screen screen1=screen.get();
            this.screenId = screen1.getScreenId();
            this.screenName = screen1.getScreenName();
            this.totalSeats = screen1.getTotalSeats();
            this.theatreId = screen1.getTheatre().getTheatreId();  // Only include the theatreId, not the whole theatre object
        }

    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }
}
