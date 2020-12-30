package com.monitor.Authentication.controller;

import com.monitor.Authentication.web.response.JwtResponse;
import com.monitor.Authentication.entity.User;
import com.monitor.Authentication.Repository.UserRepository;
import com.monitor.Authentication.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

        if (userRepository.findByEmail(user.getEmail())!=null) {
            return new String[]{"Email already registered"};
        }
            this.userRepository.insert(user);
            final String token = jwtUtility.generateToken(user.getEmail(), user.getPassword());
            return new JwtResponse(token);
    }
    //find user by email
    @PostMapping( "/login")
    public Object login(@RequestBody User user) {
        final String token=jwtUtility.generateToken(user.getEmail(), user.getPassword());
        return new JwtResponse(token);
    }

    @GetMapping("/currentUser")
    public Object user(@RequestHeader("Authorization") String jwt){
        String token = jwt.substring(7);
        String token1 =jwtUtility.getDetailsFromToken(token);
        String password = token1.substring(token1.lastIndexOf(",") + 1);
        String email = token1.substring(0, token1.indexOf(','));

        if (userRepository.findByEmail(email)!=null){
            if (userRepository.findByPassword(password)!=null){
                return  userRepository.findByPassword(password);
            }
            return new String[]{"Wrong Password"};
        }
        return new String[]{"Wrong Email"};
    }

}