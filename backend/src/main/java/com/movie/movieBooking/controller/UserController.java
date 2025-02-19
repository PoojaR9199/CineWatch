package com.movie.movieBooking.controller;

import com.movie.movieBooking.dto.LoginRequest;
import com.movie.movieBooking.dto.LoginResponse;
import com.movie.movieBooking.dto.UserDTO;
import com.movie.movieBooking.model.User;
import com.movie.movieBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {

//    private final UserService userService;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            System.out.println(registeredUser.toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        try {
            User loggedUser = userService.login(request.getEmail(),request.getPassword());
            UserDTO userDTO=new UserDTO();
            userDTO.setLoggedDetailes(loggedUser);
            return ResponseEntity.ok(new LoginResponse("Login successful", userDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(ex.getMessage(), null));
        }
    }

}
