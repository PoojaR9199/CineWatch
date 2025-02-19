package com.movie.movieBooking.service;

import com.movie.movieBooking.model.User;
import com.movie.movieBooking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //REGISTER USER
    public User registerUser(User user){

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists!");

        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword); // Hash password
        return userRepository.save(user);
    }

    //LOGIN USER
    public User login(String email, String password){
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isEmpty()) {
            throw new RuntimeException("User with email " + email + " does not exist!");
        }
        User user=existingUser.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new RuntimeException("Invalid email or password!");
        }
        return user;
    }
}
