package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.User;
import lombok.Getter;
import lombok.Setter;



public class LoginResponse {
    private String message;
    private UserDTO userDto;

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public LoginResponse(String message, UserDTO user) {
        this.message = message;
        this.userDto = user;
    }
}
