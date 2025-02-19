package com.movie.movieBooking.dto;

import com.movie.movieBooking.model.User;

public class UserDTO {
    private String name;
    private String email;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void setLoggedDetailes(User user){
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setRole(String.valueOf(user.getRole()));

    }

}
