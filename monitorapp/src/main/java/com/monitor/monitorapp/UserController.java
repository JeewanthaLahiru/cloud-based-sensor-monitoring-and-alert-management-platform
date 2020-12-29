package com.monitor.monitorapp;

import com.monitor.monitorapp.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {

    private final UserRepository userRepository;
    private final JWTUtility jwtUtility;

    @Autowired
    public UserController(UserRepository userRepository, JWTUtility jwtUtility) {
        this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
    }

    //add user
    @PostMapping("/add")
    public Object insert(@RequestBody User user) {
        this.userRepository.insert(user);
        final String token=jwtUtility.generateToken(user.getId());
        return new JwtResponse(token);
    }
    //find user by email
    @PostMapping( "/login")
    public Object login(@RequestBody User user) {
        final String token=jwtUtility.generateToken(user.getId());
        return new JwtResponse(token);
    }

    @GetMapping("/currentUser")
    public Object user(@RequestHeader("Authorization") String token){
        return userRepository.findById(jwtUtility.getIdFromToken(token));
    }

}