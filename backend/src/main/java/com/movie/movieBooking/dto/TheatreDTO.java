package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.Screen;
import com.movie.movieBooking.model.Theatre;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@NoArgsConstructor
public class TheatreDTO {

    private String theatreId;
    private String name;
    private String location;

    // Optionally, you can include a list of ScreenDTOs if you need to return screens as well
    private List<ScreenDTO> screens;

    // Constructor with parameters (optional)
//    public TheatreDTO(Optional<Theatre> optionalTheatre) {
//        if (optionalTheatre.isPresent()) {
//            Theatre theatre = optionalTheatre.get();
//            this.theatreId = theatre.getTheatreId();
//            this.name = theatre.getName();
//            this.location = theatre.getLocation();
//            this.screens = convertToScreenDTOList(theatre.getScreens());
//        }
//    }
//
//    // Utility method to convert List<Screen> to List<ScreenDTO>
//    private List<ScreenDTO> convertToScreenDTOList(List<Screen> screens) {
//        return screens.stream()
//                .map(ScreenDTO::new)  // Convert each Screen to ScreenDTO
//                .collect(Collectors.toList());
//    }


    public String getTheatreId() {
        return theatreId;
    }


    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ScreenDTO> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenDTO> screens) {
        this.screens = screens;
    }

}
